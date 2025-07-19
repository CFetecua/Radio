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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation "androidx.core:core-ktx:1.12.0" // Asegúrate de tener la última versión estable
    implementation "androidx.appcompat:appcompat:1.6.1"
    implementation "com.google.android.material:material:1.11.0"
    implementation "androidx.constraintlayout:constraintlayout:2.1.4" // Si usas ConstraintLayout

    // ExoPlayer
    implementation "androidx.media3:media3-exoplayer:1.3.1"
    implementation "androidx.media3:media3-ui:1.3.1" // Para controles de UI (opcional)
    implementation "androidx.media3:media3-session:1.3.1" // Para MediaSession

    // Para RecyclerView (si lo usas para la lista de emisoras)
    implementation "androidx.recyclerview:recyclerview:1.3.2"

    // Para cargar imágenes (ejemplo con Glide, puedes usar Coil u otra)
    // implementation "com.github.bumptech.glide:glide:4.16.0"

    // ... otras dependencias que ya tengas o necesites
    testImplementation "junit:junit:4.13.2"
    androidTestImplementation "androidx.test.ext:junit:1.1.5"
    androidTestImplementation "androidx.test.espresso:espresso-core:3.5.1"

}