plugins {
    kotlin("jvm") version "1.6.0"
}

group = "io.github.oshai"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
    implementation("com.google.flogger:flogger:0.7.2")
  testImplementation("com.google.flogger:flogger-system-backend:0.7.2")
  implementation("org.junit.jupiter:junit-jupiter:5.8.2")
}