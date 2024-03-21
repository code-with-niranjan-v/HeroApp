// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.google.dagger.hilt.android") version "2.46" apply false
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val kotlin_version = "1.5.31"
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlin_version")
    }
}