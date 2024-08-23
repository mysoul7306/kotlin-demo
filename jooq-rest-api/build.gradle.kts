plugins {
    kotlin("jvm")
}
group = "kr.co.rokroot.kotlin.demo"
version = "0.0.1-SNAPSHOT"

val libVersions = mapOf(
    "spring.boot" to "3.3.2",
    "springdoc" to "2.5.0"
)

dependencies {

    implementation("org.springframework.boot:spring-boot:${libVersions["spring.boot"]}")
    implementation("org.springframework.boot:spring-boot-autoconfigure:${libVersions["spring.boot"]}")
    implementation("org.springframework.boot:spring-boot-starter-web:${libVersions["spring.boot"]}")
    implementation("org.springframework.boot:spring-boot-starter-aop:${libVersions["spring.boot"]}")
    implementation("org.springframework.boot:spring-boot-starter-jooq:${libVersions["spring.boot"]}")

    testImplementation("org.springframework.boot:spring-boot-starter-test:${libVersions["spring.boot"]}")

}

kotlin {
    jvmToolchain(21)
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}
