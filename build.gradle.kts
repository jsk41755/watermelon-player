buildscript {
    val agp_version by extra("8.2.0")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Deps.kotlinGradlePlugin)
        classpath(Deps.androidBuildTools)
        classpath(Deps.sqlDelightGradlePlugin)
        classpath("com.android.tools.build:gradle:$agp_version")
    }
}

plugins {
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}