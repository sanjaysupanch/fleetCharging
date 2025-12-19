package com.example.fleetcharging.data.model

data class Schedule(
    val chargerId: String,
    val truckIds: List<String>
)