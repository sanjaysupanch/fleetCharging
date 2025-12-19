package com.example.fleetcharging.data.repository

import com.example.fleetcharging.data.model.Charger
import com.example.fleetcharging.data.model.Schedule
import com.example.fleetcharging.data.model.Truck
import com.example.fleetcharging.data.scheduler.ChargingScheduler

class ChargingRepository(
    private val scheduler: ChargingScheduler
) {
    fun getSchedule(
        trucks: List<Truck>,
        chargers: List<Charger>,
        totalHours: Int
    ): List<Schedule> {
        return scheduler.generateSchedule(trucks, chargers, totalHours)
    }
}