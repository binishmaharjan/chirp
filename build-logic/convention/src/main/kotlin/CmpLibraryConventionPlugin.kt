import com.binish.chirp.convention.configureAndroidTarget
import com.binish.chirp.convention.configureIosTargets
import com.binish.chirp.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

class CmpLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.kotlin.multiplatform.library")
                apply("org.jetbrains.compose")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<KotlinMultiplatformExtension> {
                targets.configureEach {
                    if (this is com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryTarget) {
                        compileSdk = libs.findVersion("projectCompileSdkVersion").get().toString().toInt()
                        minSdk = libs.findVersion("projectMinSdkVersion").get().toString().toInt()
                    }
                }
            }

            configureIosTargets()

            configurations.configureEach {
                if (name == "debugImplementation") {
                    target.dependencies.add(name, libs.findLibrary("androidx-compose-ui-tooling").get())
                }
            }
        }
    }
}
