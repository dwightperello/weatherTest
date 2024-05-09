plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    kotlin("kapt")
    alias(libs.plugins.daggerHilt)
    id ("kotlin-parcelize")
}

android {
    namespace = "com.example.weatherapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weatherapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //SPLASH
    implementation("androidx.core:core-splashscreen:1.0.1")

    //COMPOSE NAVIGATION
    val nav_version = "2.6.0"
    implementation("androidx.navigation:navigation-compose:$nav_version")

    //Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.51")
    kapt("com.google.dagger:hilt-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Retrofit
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Compose Foundation
    implementation ("androidx.compose.foundation:foundation:1.4.3")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    //Paging 3
    val paging_version = "3.1.1"
    implementation( "androidx.paging:paging-runtime:$paging_version")
    implementation( "androidx.paging:paging-compose:3.2.0-rc01")

    //Room
    val room_version = "2.6.1"
    implementation( "androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:2.6.1")


    // Local Unit Tests
    implementation( libs.androidx.core)
    testImplementation( libs.hamcrest.all)
    testImplementation( libs.androidx.core.testing)
    testImplementation( libs.robolectric)
    testImplementation( libs.kotlinx.coroutines.test)
    testImplementation( libs.truth)
    testImplementation (libs.mockito.core)
    testImplementation("com.linkedin.dexmaker:dexmaker-mockito:2.28.3")



    androidTestImplementation( "com.linkedin.dexmaker:dexmaker-mockito:2.28.3")
    androidTestImplementation( libs.junit)
    androidTestImplementation( libs.kotlinx.coroutines.test)
    androidTestImplementation( libs.androidx.core.testing)
    androidTestImplementation( libs.truth)
    androidTestImplementation( libs.androidx.junit)
    androidTestImplementation( libs.androidx.espresso.core)
    androidTestImplementation( libs.mockito.core)
    androidTestImplementation (libs.hilt.android.testing)

    kapt("com.google.dagger:hilt-android-compiler:2.51")
}