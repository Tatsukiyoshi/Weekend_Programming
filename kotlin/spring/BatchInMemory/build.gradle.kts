plugins {
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("jvm") version "2.1.0"
	kotlin("plugin.spring") version "1.8.10"
	kotlin("plugin.jpa") version "1.8.10"
}

group = "com.example"
version = "0.0.4-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_22

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.projectlombok:lombok:1.18.22")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.batch:spring-batch-test")
}

tasks.named("compileKotlin", org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask::class.java) {
	compilerOptions {
		freeCompilerArgs.add("-Xjsr305=strict")
		apiVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
