package com.example.fleetcharging.data.model

data class Truck(
    val id: String,
    val capacityKwh: Double,
    val currentChargePercent: Double
) {
    fun energyNeeded(): Double =
        capacityKwh * (1 - currentChargePercent)
}