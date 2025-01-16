import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvm("desktop") {
        //para poder usar código Java en el escritorio
        compilations.all {
           // kotlinOptions.jvmTarget = "22"
            //jvmTarget.set(JvmTarget.JVM_11)
        }
        /*compilerOptions {
            jvmTarget.set(JvmTarget.JVM_22)
        }*/
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
            implementation("io.insert-koin:koin-core:3.5.6")
           /* implementation("io.insert-koin:koin-compose:3.5.6")
            implementation("io.insert-koin:koin-compose-viewmodel:3.5.6")
            implementation("io.insert-koin:koin-compose-viewmodel-navigation:3.5.6")*/
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)


            implementation(project.dependencies.platform("org.hibernate.orm:hibernate-platform:6.6.2.Final"))
            //para entity manager
            implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")
            implementation ("org.hibernate.validator:hibernate-validator:8.0.0.Final")
            implementation ("org.glassfish:jakarta.el:4.0.2")
            //nucleo
            implementation ("org.hibernate.orm:hibernate-core")
            //dependencias
            implementation ("jakarta.transaction:jakarta.transaction-api")
            //driver
            // https://mvnrepository.com/artifact/org.xerial/sqlite-jdbc
           // implementation("com.mysql:mysql-connector-j")
            // https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-community-dialects
            implementation("org.hibernate.orm:hibernate-community-dialects:6.6.4.Final")
            // implementation("org.hibernate.orm:hibernate-community-dialects:6.6.4.Final")
            implementation("com.mysql:mysql-connector-j:9.1.0")

            runtimeOnly("com.mysql:mysql-connector-j:9.1.0")
            //para los logs
            implementation("org.apache.logging.log4j:log4j-core:2.24.1")
           // annotationProcessor ("org.hibernate.orm:hibernate-jpamodelgen:6.6.3.Final")

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
