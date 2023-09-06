plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("plugin.serialization") version "1.5.31"
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 22
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))
    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("io.insert-koin:koin-android:3.0.1")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")

    //kapt("com.github.Raizlabs.DBFlow:dbflow-processor:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow-core:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow-kotlinextensions:4.2.4")
    annotationProcessor("com.github.Raizlabs.DBFlow:dbflow-processor:4.2.4")

    implementation("androidx.work:work-runtime-ktx:2.6.0-beta01")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")

    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")

    implementation ("io.ktor:ktor-client-android:1.5.0")
    implementation ("io.ktor:ktor-client-serialization:1.5.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation ("io.ktor:ktor-client-logging-jvm:1.5.0")
    implementation("io.ktor:ktor-client-okhttp:1.5.0")



}