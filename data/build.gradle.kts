plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    kotlin("kapt")
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        javaCompileOptions {
            annotationProcessorOptions {
                arguments["room.schemaLocation"] = "$projectDir/schemas"
                arguments["room.incremental"] = "true"
                arguments["room.expandProjection"] = "true"
            }
        }
    }

//    buildTypes {
//        getByName(AppConfig.BuildTypes.release) {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//        getByName(AppConfig.BuildTypes.debug) {
//            isMinifyEnabled = false
//            versionNameSuffix = "-${AppConfig.BuildTypes.debug}"
//        }
//    }

//    flavorDimensions(AppConfig.dimension)
//
//    productFlavors {
//        create(AppConfig.ProductFlavors.staging) {
//            setDimension(AppConfig.dimension)
//            versionNameSuffix = "-${AppConfig.ProductFlavors.staging}"
//        }
//
//        create(AppConfig.ProductFlavors.production) {
//            setDimension(AppConfig.dimension)
//        }
//    }
//
//    viewBinding {
//        android.buildFeatures.viewBinding = true
//    }
//
//    packagingOptions {
//        exclude("META-INF/notice.txt")
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":domain"))

    //data libs
    implementation(AppDependencies.dataLibraries)
    //data compilers
    kapt(AppDependencies.dataCompilers)
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

}