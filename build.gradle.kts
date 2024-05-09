import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import java.io.File

// Compiletime 이 아닌 Runtime 시에 동작하므로 buildscript 에 의존성 추가
// Gradle 초기 설정 단계에서 클래스 경로가 설정되어야 하므로 buildscript 블록은 스크립트 파일의 상단에 위치
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.fasterxml.jackson.core:jackson-databind:2.15.0")
        classpath("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")
    }
}

// 메인 프로젝트와 경로를 맞춰줘야 런타임 시에 정상적으로 주입이 된다
sourceSets {
    val main by getting {
        resources.srcDirs("src/main/resources", "security-module/brain-back/src/main/resources")
    }
}

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

// gradle 에서 yml 을 읽어오기 위한 설정
tasks.register("readYaml") {
    doLast {
        val file = File("security-module/brain-back/src/main/resources/application.yml")
        val mapper = ObjectMapper(YAMLFactory())
        val config = mapper.readValue(file, Map::class.java)
        println(config)
    }
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


    // Jackson yaml
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")

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