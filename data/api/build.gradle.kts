plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.pkgupta.sampleapp.api"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofitConverterMoshi)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)
}