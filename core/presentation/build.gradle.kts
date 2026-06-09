plugins {
    alias(libs.plugins.convention.cmp.library)
}

kotlin {

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)

                // Module dependencies here
                implementation(projects.core.domain)
                implementation(projects.core.designsystem)

                // Add KMP dependencies here
                implementation(compose.components.resources)
                implementation(libs.material3.adaptive)
            }
        }

        androidMain {
            dependencies {
            }
        }

        iosMain {
            dependencies {
            }
        }
    }

}