package com.example.fleetcharging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.fleetcharging.ui.screens.ChargingScreen
import com.example.fleetcharging.ui.theme.FleetChargingTheme
import com.example.fleetcharging.ui.viewmodel.ChargingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: ChargingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FleetChargingTheme {
                ChargingScreen(vm.schedule.collectAsState().value)
            }
        }
    }
}