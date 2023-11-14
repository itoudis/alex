val javaVersion by extra(17)

plugins {
    id("java")
}

group = "org.itoudis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain { languageVersion.set(JavaLanguageVersion.of(javaVersion)) }
    withSourcesJar()
}

java.sourceCompatibility = JavaVersion.toVersion(javaVersion)


dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}