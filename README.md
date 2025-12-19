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

## Project Structure

<img width="235" height="246" alt="Screenshot 2025-12-19 at 4 14 05 PM" src="https://github.com/user-attachments/assets/9bf13a71-2234-473f-9de5-14cb52469b5e" />

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

## Sample Input and Output

### Sample Input

**Trucks**
- Truck_1: 160 kWh capacity, 10% charged
- Truck_2: 150 kWh capacity, 20% charged
- Truck_3: 130 kWh capacity, 25% charged
- Truck_4: 120 kWh capacity, 30% charged
- Truck_5: 110 kWh capacity, 40% charged

**Chargers**
- Charger_1: 60 kW
- Charger_2: 40 kW

**Time Window**
- 8 hours

---

### Expected Output

Based on the greedy scheduling algorithm, the charging schedule will be:

```text
Charger_1: Truck_5, Truck_4, Truck_3, Truck_2
Charger_2: Truck_1

