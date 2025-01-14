import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("org.springframework.boot") version "3.4.1"
    id("io.spring.dependency-management") version "1.1.7"
}

kotlin {
    jvm("desktop") {
        //para poder usar código Java en el escritorio
        compilations.all {
           // kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
    }
    //jvmToolchain(8)
    
    sourceSets {
        val desktopMain by getting
        
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.8.0-alpha11")
            implementation("org.jetbrains.compose.material:material-icons-extended:1.5.0")
            //kit iconos https://github.com/DevSrSouza/compose-icons
            //serializar y deserializar
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
            //para poder usarlo en java
            implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
            //adaptativo
            implementation("org.jetbrains.compose.material3.adaptive:adaptive:1.0.0-alpha03")
            implementation("org.jetbrains.compose.material3.adaptive:adaptive-layout:1.0.0-alpha03")
            implementation("org.jetbrains.compose.material3.adaptive:adaptive-navigation:1.0.0-alpha03")
            implementation(compose.material3AdaptiveNavigationSuite)
            implementation("org.jetbrains.compose.material3:material3-window-size-class:1.7.3")
            implementation("org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")

            //gráficos
            implementation("org.jetbrains.lets-plot:lets-plot-kotlin-kernel:4.9.3")
            implementation("org.jetbrains.lets-plot:lets-plot-common:4.5.2")
            implementation("org.jetbrains.lets-plot:platf-awt:4.5.2")
            implementation("org.jetbrains.lets-plot:lets-plot-compose:2.1.1")

            //logs
            implementation("org.slf4j:slf4j-api:2.0.9") // SLF4J API
            implementation("ch.qos.logback:logback-classic:1.4.11") // Implementación de Logback
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
            implementation("org.springframework.boot:spring-boot-starter-data-jpa")
            runtimeOnly("com.mysql:mysql-connector-j")
        }
    }
}


compose.desktop {
    application {
        mainClass = "ies.sequeros.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ies.sequeros"
            packageVersion = "1.0.0"
        }
    }
}
