package com.example.fleetcharging.di

import com.example.fleetcharging.data.scheduler.ChargingScheduler
import com.example.fleetcharging.data.scheduler.GreedyChargingScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SchedulerModule {

    @Provides
    @Singleton
    fun provideScheduler(): ChargingScheduler =
        GreedyChargingScheduler()
}