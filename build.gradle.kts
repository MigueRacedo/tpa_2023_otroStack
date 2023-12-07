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
    // Implementation Dependencies
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("com.twilio.sdk:twilio:8.13.0")
    //implementation("io.github.flbulgarelli:jpa-extras:1.0.0-rc1")
    //implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("org.passay:passay:1.6.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.thymeleaf:thymeleaf:3.1.2.RELEASE")

    implementation("org.hibernate:hibernate-core:6.2.6.Final")
    implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")
    implementation("org.hibernate:hibernate-validator:6.2.0.Final") // (Optional) Hibernate Validator for bean validation

    // Add your other dependencies here...

    // PostgreSQL JDBC driver (assuming you are using PostgreSQL)
    implementation("org.postgresql:postgresql:42.2.27")

    // H2 Database (for testing purposes, you can exclude this if not needed)
    runtimeOnly("com.h2database:h2:1.4.200")
    // Lombok Dependencies
    implementation("org.projectlombok:lombok:1.18.30")
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // Runtime Dependencies
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.postgresql:postgresql") // Commented out as Spring Boot includes a compatible version
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")

    // Test Dependencies
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}