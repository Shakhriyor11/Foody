plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
//    id("kotlin-android-extensions")
}

android {
    namespace = "com.example.foody"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.foody"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

//    CoordinatorLayout
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

//    Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

//    Room Components
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    androidTestImplementation("androidx.room:room-testing:2.6.1")

//    Data Binding
//    kapt("androidx.databinding:databinding-compiler:8.1.0")
//    kapt("androidx.databinding:databinding-common:8.4.1")

//    Data Store
    implementation("androidx.datastore:datastore-preferences:1.1.1")

//    Recyclerview
    implementation("androidx.recyclerview:recyclerview:1.3.2")

//    Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

//    Dagger-Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

//    Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

//    Lifecycle
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")

//    Image Loading Library Coil
    implementation("io.coil-kt:coil:2.4.0")

//    Gson
//    implementation("com.google.code.gson:gson:2.10.0")

//    Shimmer
    implementation("com.facebook.shimmer:shimmer:0.5.0")

//    Jsoup
    implementation("org.jsoup:jsoup:1.16.1")

    // Kotlin-Parcelize
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")
//    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.22")

}