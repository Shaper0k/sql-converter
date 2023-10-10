plugins {
	java
	id("org.springframework.boot") version "3.2.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.ru.rtech"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	//OTHER
	implementation("commons-io:commons-io:2.14.0")
	implementation("commons-fileupload:commons-fileupload:1.5")
	implementation("org.apache.commons:commons-lang3:3.12.0")
	implementation("org.apache.commons:commons-collections4:4.4")
	implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-csv:2.13.3")
	implementation("com.opencsv:opencsv:5.8")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	//TEST
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.mockito:mockito-inline:4.11.0")
	testImplementation("org.jeasy:easy-random-core:5.0.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
