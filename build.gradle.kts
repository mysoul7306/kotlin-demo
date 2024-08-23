/*
 * Author: rok_root
 * E-mail: mysoul7306@outlook.com
 * Create: 2023. 09. 30
 * Update: 2024. 08. 10
 * All Rights Reserved
 */

plugins {
    java
    application
    kotlin("jvm") version "2.0.10"
}

extra.apply {
    set("VERSION", "0.0.1")
    if (project.hasProperty("profile")) {
        set("ACTIVE_PROFILE", project.property("profile").toString())
    } else {
        set("ACTIVE_PROFILE", "dev")
    }
}

version = extra["VERSION"] as String
group = "kr.co.rokroot.kotlin.demo"
description = "ROK_ROOT Kotlin Demo project"

allprojects {
    buildscript {
        repositories {
            mavenCentral()
            google()
        }
    }

    repositories {
        mavenCentral()
        google()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "application")

    version = rootProject.extra["VERSION"] as String

    tasks.withType(JavaCompile::class.java) {
        options.encoding = "UTF-8"
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21

        withSourcesJar()
    }

    val libVersions = mapOf(
        "kotlin" to "2.0.10",
        "apache.log4j" to "2.22.0",
        "apache.commons" to "2.12.0",
        "apache.lang" to "3.12.0",
        "hibernate" to "6.5.2.Final",
        "jackson" to "2.17.2",
        "simple.json" to "1.1.1",
        "ipaddress" to "5.4.0",
        "mockito" to "5.7.0",
        "jUnit" to "5.11.0"
    )

    dependencies {

        implementation("org.jetbrains.kotlin:kotlin-stdlib:${libVersions["kotlin"]}")
        implementation("org.jetbrains.kotlin:kotlin-reflect:${libVersions["kotlin"]}")

        implementation("org.apache.logging.log4j:log4j-core:${libVersions["apache.log4j"]}")
        implementation("org.apache.logging.log4j:log4j-api:${libVersions["apache.log4j"]}")
        implementation("org.apache.logging.log4j:log4j-slf4j2-impl:${libVersions["apache.log4j"]}")

        implementation("commons-io:commons-io:${libVersions["apache.commons"]}")
        implementation("org.apache.commons:commons-lang3:${libVersions["apache.lang"]}")

        implementation("org.hibernate.orm:hibernate-core:${libVersions["hibernate"]}")
        implementation("com.fasterxml.jackson.core:jackson-databind:${libVersions["jackson"]}")
        implementation("com.googlecode.json-simple:json-simple:${libVersions["simple.json"]}")
        implementation("com.github.seancfoley:ipaddress:${libVersions["ipaddress"]}")

        testImplementation("org.apache.logging.log4j:log4j-core:${libVersions["apache.log4j"]}")
        testImplementation("org.apache.logging.log4j:log4j-slf4j2-impl:${libVersions["apache.log4j"]}")

        testImplementation("org.mockito:mockito-core:${libVersions["mockito"]}")

        testImplementation("org.junit.jupiter:junit-jupiter-api:${libVersions["jUnit"]}")
        testImplementation("org.junit.jupiter:junit-jupiter-engine:${libVersions["jUnit"]}")
        testImplementation("org.junit.jupiter:junit-jupiter-params:${libVersions["jUnit"]}")

        testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:${libVersions["kotlin"]}")

    }

    configurations.all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
        exclude(group = "ch.qos.logback", module = "logback-classic")
        exclude(group = "commons-logging", module = "commons-logging")
    }

    tasks {
        jar {
            manifest {
                attributes["Built-By"] = System.getProperty("user.name")
                attributes["Build-Jdk"] = System.getProperty("java.version")
            }
        }

        test {
            useJUnitPlatform()
        }
    }
}
