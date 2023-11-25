plugins {
    id("org.springframework.boot") version("3.1.4")
    id("io.spring.dependency-management") version("1.1.3")
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.thymeleaf:thymeleaf:3.1.2.RELEASE")
    implementation("org.passay:passay:1.6.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("io.github.flbulgarelli:jpa-extras:1.0.0-rc1")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.projectlombok:lombok:1.18.26")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}