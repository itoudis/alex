val javaVersion by extra(17)

plugins {
    id("java")
}

repositories {
    // TODO gereksiz varsa kaldır
    gradlePluginPortal()
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
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