plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)

}

android {
    namespace = "com.vobot.rentals.core.data"
    compileSdk = 36
}

kotlin {
    jvmToolchain(17)
}




dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.koin.android)

    api(projects.core.model)


}