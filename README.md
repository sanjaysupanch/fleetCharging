# Fleet Charging Scheduler

## Overview
A simple Android app that schedules electric trucks on available chargers to **maximize the number of fully charged trucks** within a fixed time window.

## Problem
- Trucks have battery capacity and current charge
- Chargers have different charging rates
- One truck can be charged per charger at a time
- Charging cannot be interrupted
- Chargers work in parallel

## Scheduling Algorithm

The app uses a **greedy scheduling algorithm**.

Trucks are first sorted by the amount of energy they need to become fully charged (least energy first).  
Chargers are then processed from fastest to slowest.

Each charger gets the full available time window. Trucks are assigned to a charger as long as they can finish charging within the remaining time.  
Once a truck is assigned, it is removed so it cannot be scheduled again.

This approach is simple, fast, and reasonable for maximizing the number of fully charged trucks, which is the main goal of the assignment.  

## Architecture

- **MVVM** - ViewModel manages UI state using `StateFlow`
- **Jetpack Compose UI** - Modern declarative UI framework
- **Dependency Injection (Hilt)** - Provides `ChargingRepository` and `ChargingScheduler` instances
- **Repository Pattern** - `ChargingRepository` abstracts scheduling logic from UI
- Scheduling logic is decoupled from UI through the `ChargingScheduler` interface

## Tech Stack

| Component | Technology |
|-----------|-----------|
| UI Framework | Jetpack Compose, Material 3 |
| Architecture | MVVM |
| Dependency Injection | Hilt |
| State Management | Kotlin Coroutines `StateFlow` |
| Language | Kotlin |
| Build System | Gradle (KTS) |

## UI

- Single screen displaying the charging schedule
- Shows chargers and their assigned trucks in a scrollable list
- Each charger card displays:
  - Charger ID
  - Number of assigned trucks
  - List of truck IDs assigned to that charger
- Shows an empty state warning when no trucks are assigned to a charger

- Preview: <img width="1080" height="2400" alt="Screenshot_20251219_152225" src="https://github.com/user-attachments/assets/096b55b6-8ec3-4faf-a71e-ef48d8137e70" />
<img width="1080" height="2400" alt="Screenshot_20251219_152124" src="https://github.com/user-attachments/assets/60510ce6-ae71-432c-a85a-9f41a748a2a5" />


## How to Run

1. Open the project in Android Studio
2. Sync Gradle
3. Run the app on an emulator or physical device (minSdk: 26)

## Sample Data

The app uses predefined sample data:
- **5 Trucks** with varying battery capacities (110-160 kWh) and charge levels (10-40%)
- **2 Chargers** with different charging rates (40 kW and 60 kW)
- **Time Window**: 8 hours

The schedule is automatically generated when the app launches.

