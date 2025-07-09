plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)

}

android {
    namespace = "com.vobot.rentals.core.model"
    compileSdk = 35
}

kotlin{
    jvmToolchain(17)
}




dependencies {

    implementation(libs.androidx.core.ktx)

    implementation(libs.coil.compose)

}