# Modular Android Clean Architecture App

A sample Android application built using **Kotlin**, **Jetpack Compose**, **Hilt**, and **Clean Architecture** principles with modularization to ensure scalability, testability, and separation of concerns.

## 📦 Module Structure
- **app**: Android Application Module (entry point)
- **api**: Data source (e.g., Retrofit API interfaces, DTOs)
- **repository**: Data layer (handles mapping and coordination between API and domain)
- **domain**: Business logic (UseCases, domain models, interfaces)
- **presentation**: UI Layer (Jetpack Compose, ViewModels, UI Models)
- **di**: Dependency Injection setup (Hilt modules)

## 🚀 Tech Stack

### 🧱 Architecture
- **Clean Architecture**: separation into data, domain, and presentation layers
- **Modularization**: each layer is a standalone Gradle module
- **MVVM**: ViewModel and State management

### 🛠️ Tech & Libraries
- **Kotlin**
- **Jetpack Compose** for UI
- **Hilt** for dependency injection
- **Kotlin Coroutines + Flow** for async and reactive data handling
- **Retrofit** for networking (in `api` module)
- **MockK** and **JUnit** for unit testing
- **Turbine** for Flow testing
- **Parcelize** (for data passing between components)
- **Gradle Kotlin DSL**

🚧 Future Improvements
- Add logging at different levels
- Add UI tests using espresso
- Add offline caching using Room
- Add localization support


