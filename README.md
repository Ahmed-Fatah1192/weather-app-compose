# Weather App with Saved Cities (Kotlin + Jetpack Compose)

An Android weather app where users log in, save cities they care about, and check live current weather for each one built to practice a full, realistic app architecture: local login, a real local database, public API integration, and multi-screen navigation.

## Features

- **Local login screen** simple local/mock authentication gating access to the app (not a real backend auth system)
- **Live weather data** fetches current temperature, conditions, and humidity from the OpenWeatherMap API
- **Saved cities with full CRUD** add a city, view your saved list, tap in for live weather detail, remove a city you no longer want
- **Local database persistence** saved cities stored with Room (SQLite), surviving app restarts
- **Multi-screen navigation** Login → City List → City Detail, using Jetpack Navigation Compose
- **Proper loading/error states** a misspelled or invalid city name shows a clear error message instead of crashing or silently failing

## Tech Stack

- **Kotlin** + **Jetpack Compose**
- **Retrofit** + **Gson** networking and JSON parsing
- **Room** local SQLite database
- **Navigation Compose** multi-screen navigation
- **ViewModel + StateFlow** state management surviving configuration changes
- **Repository pattern** separates data logic (network + database) from the UI layer

## What I practiced building this

- Structuring an app with a proper **Repository** and **ViewModel** layer instead of putting everything in the UI
- Real networking with Retrofit, including handling loading and error states, not just the "happy path"
- Room database CRUD operations and exposing live-updating data via Kotlin `Flow`/`StateFlow`
- Multi-screen navigation and passing data between screens
- Keeping API keys out of version control using `local.properties` and `BuildConfig`
- Diagnosing and fixing several real tooling/version-compatibility issues along the way (KSP/Kotlin version matching, Room/KSP2 bug workaround, AGP/dependency version conflicts) — debugging build tooling issues, not just app logic

## Getting Started

Clone the repo:

```bash
git clone https://github.com/Ahmed-Fatah1192/weather-app-compose.git
```

You'll need your own free OpenWeatherMap API key (openweathermap.org) — add it to a `local.properties` file in the project root as:
```
WEATHER_API_KEY=your_key_here
```

Then open in Android Studio and run.

## Screenshots

*(add a screenshot or short gif of the app here)*
