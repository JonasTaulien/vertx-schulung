plugins {
    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")

    // Use Mockito for testing
    testImplementation("org.mockito:mockito-core:4.4.0")

    implementation("com.google.inject:guice:5.1.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
