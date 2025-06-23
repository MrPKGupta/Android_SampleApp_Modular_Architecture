plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.pkgupta.sampleapp.di"
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
    implementation(project(":domain"))
    implementation(project(":data:api"))
    implementation(project(":data:repository"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.okhttp)
    implementation(libs.okhttpLoggingInterceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofitConverterMoshi)
    implementation(libs.moshi)
    implementation(libs.moshiKotlin)
}