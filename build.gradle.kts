plugins {
    `java-library`
    `maven-publish`
    id("io.izzel.taboolib") version "1.51"
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
}

taboolib {
    install("common")
    install("common-5")
    install("module-chat")
    install("module-lang")
    install("module-nms")
    install("module-nms-util")
    install("platform-bukkit")
    classifier = null
    version = "6.0.10-38"
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("ink.ptms.core:v11800:11800-minimize:mapped")
    compileOnly("ink.ptms.core:v11605:11605")
    compileOnly("ink.ptms.core:v11300:11300")
    compileOnly(kotlin("stdlib"))
    compileOnly(fileTree("libs"))
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.tabooproject.org/repository/releases")
            credentials {
                username = project.findProperty("taboolibUsername").toString()
                password = project.findProperty("taboolibPassword").toString()
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("library") {
            from(components["java"])
            groupId = project.group.toString()
        }
    }
}