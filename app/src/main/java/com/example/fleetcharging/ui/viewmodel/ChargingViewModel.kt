package com.example.fleetcharging.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fleetcharging.data.model.Schedule
import com.example.fleetcharging.data.repository.ChargingRepository
import com.example.fleetcharging.utils.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class ChargingViewModel @Inject constructor(
    private val repository: ChargingRepository
) : ViewModel() {

    private val _schedule = MutableStateFlow<List<Schedule>>(emptyList())
    val schedule: StateFlow<List<Schedule>> = _schedule

    init {
        loadSchedule()
    }

    private fun loadSchedule() {
        _schedule.value = repository.getSchedule(
            trucks = SampleData.trucks,
            chargers = SampleData.chargers,
            totalHours = 8
        )
    }
}