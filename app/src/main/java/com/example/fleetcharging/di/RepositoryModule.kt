package com.example.fleetcharging.di

import com.example.fleetcharging.data.repository.ChargingRepository
import com.example.fleetcharging.data.scheduler.ChargingScheduler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
        scheduler: ChargingScheduler
    ): ChargingRepository =
        ChargingRepository(scheduler)
}