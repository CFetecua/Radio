plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.radio"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.radio"
        minSdk = 24
        targetSdk = 36
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx) // Desde el catalog
    implementation(libs.androidx.appcompat) // Desde el catalog
    implementation(libs.material) // Desde el catalog
    // ... y así sucesivamente para las que estén en tu catalog

    // Para las que NO estén en tu catalog (como ExoPlayer si no lo has añadido allí)
    // puedes declararlas directamente:
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")
    implementation("androidx.media3:media3-session:1.3.1")
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // ...
    testImplementation(libs.junit) // Asumiendo que junit está en tu catalog
    androidTestImplementation(libs.androidx.junit) // Asumiendo que androidx.junit está en tu catalog
    androidTestImplementation(libs.androidx.espresso.core) // Asumiendo que espresso.core está en tu catalog
}
