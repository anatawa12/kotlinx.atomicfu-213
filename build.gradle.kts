buildscript {
    repositories.mavenCentral()
    dependencies.classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.16.3")
}

plugins {
    kotlin("jvm") version "1.6.0"
}

apply<kotlinx.atomicfu.plugin.gradle.AtomicFUGradlePlugin>()

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation(platform(kotlin("bom")))
    implementation(kotlin("stdlib-jdk8"))
}
