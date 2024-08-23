/*
 * Author: rok_root
 * E-mail: mysoul7306@outlook.com
 * Create: 2023. 09. 30
 * Update: 2024. 08. 10
 * All Rights Reserved
 */

rootProject.name = "rokroot-kotlin-demo"
include("core")
include("jooq-rest-api")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
    plugins {
        kotlin("jvm") version "2.0.10"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
