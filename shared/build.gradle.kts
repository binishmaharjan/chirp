import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }
    
    androidLibrary {
       namespace = "com.binish.chirp.shared"
       compileSdk = libs.versions.projectCompileSdkVersion.get().toInt()
       minSdk = libs.versions.projectMinSdkVersion.get().toInt()
    
       compilerOptions {
           jvmTarget = JvmTarget.JVM_11
       }
       androidResources {
           enable = true
       }
       withHostTest {
           isIncludeAndroidResources = true
       }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(project.dependencies.platform(libs.androidx.compose.bom))
            implementation(libs.androidx.compose.ui.tooling.preview)
        }
        commonMain.dependencies {
            // Module
            implementation(projects.core.data)
            implementation(projects.core.domain)
            implementation(projects.core.designsystem)
            implementation(projects.core.presentation)

            implementation(projects.feature.auth.domain)
            implementation(projects.feature.auth.presentation)

            implementation(projects.feature.chat.domain)
            implementation(projects.feature.chat.presentation)
            implementation(projects.feature.chat.data)
            implementation(projects.feature.chat.database)

            // Android Framework
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(libs.jetbrains.compose.viewmodel)
            implementation(libs.jetbrains.lifecycle.compose)
        }
    }
}

dependencies {
    androidRuntimeClasspath(platform(libs.androidx.compose.bom))
    androidRuntimeClasspath(libs.androidx.compose.ui.tooling)
}

tasks.withType<org.gradle.api.tasks.testing.Test> {
    failOnNoDiscoveredTests = false
}