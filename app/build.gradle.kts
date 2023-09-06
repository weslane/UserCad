plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
    id("kotlin-kapt")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("plugin.serialization") version "1.5.31"
}

android {
    namespace = "com.mwsa.usercad"
    compileSdk = 30
    buildToolsVersion = "30.0.2"

    defaultConfig {
        applicationId = "com.mwsa.usercad"
        minSdk = 22
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(kotlin("stdlib-jdk7", "1.5.21"))


    implementation(project(":domain"))
    implementation(project(":infrastructure"))
    implementation(project(":ui"))
    implementation(project(":di"))

    //kapt("com.github.Raizlabs.DBFlow:dbflow-processor:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow-core:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow:4.2.4")
    implementation("com.github.Raizlabs.DBFlow:dbflow-kotlinextensions:4.2.4")
    annotationProcessor("com.github.Raizlabs.DBFlow:dbflow-processor:4.2.4")

    implementation ("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.appcompat:appcompat:1.2.0")
    implementation ("com.google.android.material:material:1.2.0")
    implementation ("androidx.constraintlayout:constraintlayout:1.1.3")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    implementation("com.android.support:support-annotations:28.0.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("androidx.work:work-runtime-ktx:2.6.0-beta01")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.1")
    implementation ("io.insert-koin:koin-android:3.0.1")

    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")

    implementation("io.ktor:ktor-client-core:1.5.0")
    implementation("io.ktor:ktor-client-cio:1.5.0")

}