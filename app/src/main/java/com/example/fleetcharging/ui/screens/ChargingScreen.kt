package com.example.fleetcharging.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.fleetcharging.data.model.Schedule
import com.example.fleetcharging.ui.components.ChargerCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChargingScreen(schedules: List<Schedule>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Fleet Charging Schedule",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(schedules) { schedule ->
                ChargerCard(schedule)
            }
        }
    }
}