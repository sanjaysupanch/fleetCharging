package com.example.fleetcharging.data.scheduler

import com.example.fleetcharging.data.model.Charger
import com.example.fleetcharging.data.model.Schedule
import com.example.fleetcharging.data.model.Truck

interface ChargingScheduler {
    fun generateSchedule(
        trucks: List<Truck>,
        chargers: List<Charger>,
        totalHours: Int
    ): List<Schedule>
}