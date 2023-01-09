plugins {
    kotlin("jvm") version "1.7.22"
    id("io.ktor.plugin") version "2.2.1"
    kotlin("plugin.serialization").version("1.7.22")
}

application {
    mainClass.set("org.example.MyServiceKt")
}

ktor {
    fatJar {
        archiveFileName.set("fat.jar")
    }
}

repositories {
    mavenCentral()
}

dependencies {

    val ktorVersion: String by project

    // Server
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")

    // Client
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")

    // Common
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
}