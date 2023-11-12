plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
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
        commonMain.dependencies {
            implementation(Deps.ktorCore)
            implementation(Deps.ktorSerialization)
            implementation(Deps.ktorSerializationJson)
            implementation(Deps.sqlDelightRuntime)
            implementation(Deps.sqlDelightCoroutinesExtensions)
            implementation(Deps.kotlinDateTime)
            implementation(Deps.media3)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
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