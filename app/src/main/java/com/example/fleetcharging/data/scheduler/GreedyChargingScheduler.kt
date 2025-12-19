package com.example.fleetcharging.data.scheduler

import com.example.fleetcharging.data.model.Charger
import com.example.fleetcharging.data.model.Schedule
import com.example.fleetcharging.data.model.Truck

class GreedyChargingScheduler : ChargingScheduler {

    override fun generateSchedule(
        trucks: List<Truck>,
        chargers: List<Charger>,
        totalHours: Int
    ): List<Schedule> {

        // Sort trucks by least energy needed (shortest job first)
        val remainingTrucks = trucks
            .sortedBy { it.energyNeeded() }
            .toMutableList()

        val schedules = mutableListOf<Schedule>()

        // Each charger works independently for the full time window
        chargers.sortedByDescending { it.rateKw }.forEach { charger ->
            var remainingTime = totalHours.toDouble()
            val assigned = mutableListOf<String>()

            val iterator = remainingTrucks.iterator()
            while (iterator.hasNext()) {
                val truck = iterator.next()
                val timeNeeded = truck.energyNeeded() / charger.rateKw

                if (timeNeeded <= remainingTime) {
                    remainingTime -= timeNeeded
                    assigned.add(truck.id)
                    iterator.remove()
                }
            }

            schedules.add(Schedule(charger.id, assigned))
        }

        return schedules
    }
}