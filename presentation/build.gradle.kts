plugins {
    alias(libs.plugins.kotlin.compose)
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.pkgupta.sampleapp.presentation"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.lifecycleRuntime)
    implementation(libs.lifecycleViewModel)
    implementation(libs.lifecycleViewModelCompose)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended.v143)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)

    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    implementation(libs.navigationCompose)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.coil)
    implementation(libs.coilCompose)

    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.turbine)
}