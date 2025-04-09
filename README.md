# Product Catalog App - KMM Developer Assignment

![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-purple?logo=kotlin)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5.4-blue?logo=android)
![Ktor](https://img.shields.io/badge/Ktor-2.3.5-green?logo=kotlin)

A Kotlin Multiplatform Mobile (KMM) application showcasing product listings with Jetpack Compose UI and Ktor networking.

## 📱 Features
- Product listing with pagination
- Product detail view
- Modern Jetpack Compose UI
- MVVM architecture
- Ktor networking client
- Coil image loading
- Error handling and loading states

## 🛠️ Technical Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Networking**: Ktor Client
- **DI**: Koin
- **Image Loading**: Coil
- **Architecture**: MVVM with Clean Architecture principles

## ⚙️ Setup Instructions

### Prerequisites
- Android Studio Giraffe (2022.3.1) or newer
- JDK 11+
- Android SDK 34+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/AdityaPrakash-03/KMM-Developer-Assignment.git
2.Open project in Android Studio

3.Sync Gradle dependencies

4.Build and run the app (▶️ button)

🌐 API Configuration
The app uses DummyJSON API:

Base URL: https://dummyjson.com/products

Endpoints:

GET /products - Get all products

GET /products/{id} - Get single product
