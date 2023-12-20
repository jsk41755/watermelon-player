plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version Deps.kotlinVersion
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(Deps.ktorAndroid)
        }
        commonMain.dependencies {
            implementation(Deps.ktorCore)
            implementation(Deps.ktorSerialization)
            implementation(Deps.ktorSerializationJson)
            implementation(Deps.kotlinDateTime)
            implementation(Deps.media3)
            implementation(platform(Deps.supabase))
            implementation(Deps.supabasePostgrest)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        iosMain.dependencies {
            implementation(Deps.ktorIOS)
        }
    }
}

android {
    namespace = "com.devjeong.watermelon_player"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}