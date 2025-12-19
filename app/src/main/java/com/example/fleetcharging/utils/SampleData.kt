package com.example.fleetcharging.utils

import com.example.fleetcharging.data.model.Charger
import com.example.fleetcharging.data.model.Truck

object SampleData {

    val trucks = listOf(
        Truck("Truck_1", 160.0, 0.10),
        Truck("Truck_2", 150.0, 0.20),
        Truck("Truck_3", 130.0, 0.25),
        Truck("Truck_4", 120.0, 0.30),
        Truck("Truck_5", 110.0, 0.40)
    )

    val chargers = listOf(
        Charger("Charger_1", 60.0),
        Charger("Charger_2", 40.0)
    )
}