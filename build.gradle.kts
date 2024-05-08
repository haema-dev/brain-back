import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
    kotlin("kapt") version "1.8.22"
}

group = "power"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

// Main Class 지정(꼭 필요!! 없으면 빌드시에 메인 class 못 찾아서 에러남)
application {
    mainClass.set("power.brain.BrainApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Default
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // Kotlin Module
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // Database MySQL
    runtimeOnly("mysql:mysql-connector-java:8.0.33")
    // MapStruct
//    implementation("org.mapstruct:mapstruct:1.8.22")
    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")// openApi 와 SwaggerUI 를 통합하기 위해 추가

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}