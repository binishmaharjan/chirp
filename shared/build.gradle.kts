import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.android.build.api.dsl.LibraryExtension

plugins {
    alias(libs.plugins.convention.cmp.library)
    alias(libs.plugins.compose.hot.reload)
}

extensions.configure<LibraryExtension> {
    namespace = "com.binish.chirp.shared"
}

kotlin {
    
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

            // DI
            implementation(libs.bundles.koin.common)
        }
    }
}

tasks.withType<org.gradle.api.tasks.testing.Test> {
    failOnNoDiscoveredTests = false
}