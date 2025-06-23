plugins {
    alias(libs.plugins.android.application)
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.pkgupta.sampleapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pkgupta.sampleapp"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(project(":presentation"))
    implementation(project(":di"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
}
