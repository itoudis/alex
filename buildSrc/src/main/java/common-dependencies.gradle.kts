plugins { `java-library` }


repositories {
    mavenCentral()
}

dependencies {
    // Spring dependencies
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    //implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2022.0.3"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    //implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    //    implementation("org.springframework.boot:spring-boot-starter-security")
    //implementation("org.springframework.boot:spring-boot-starter-validation")
    //implementation("org.springframework.boot:spring-boot-starter-mail")
    //implementation("org.springframework.boot:spring-boot-devtools")
    //implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Testcontainer dependencies
    //implementation("org.testcontainers:testcontainers:1.17.6")
    //implementation("org.testcontainers:junit-jupiter:1.17.6")
    //implementation("org.testcontainers:postgresql:1.17.6")


    // DB dependencies
    //implementation("org.liquibase:liquibase-core")
    implementation("org.postgresql:postgresql")

    // Logbook dependencies
    //implementation("org.zalando:logbook-spring-boot-starter:3.3.0")


    // Test dependencies
    //testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
    //testImplementation("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.security:spring-security-test")
    implementation("io.awspring.cloud:spring-cloud-aws-starter-s3:3.0.0-RC1")


    //implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    //implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    //implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")


    //implementation("net.logstash.logback:logstash-logback-encoder:7.3")
}
