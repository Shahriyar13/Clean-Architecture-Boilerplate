plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.daggerHilt)
    id(BuildPlugins.navigationSafeArgs)
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

        multiDexEnabled = true

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
//
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

    viewBinding {
        android.buildFeatures.dataBinding = true
        android.buildFeatures.viewBinding = true
    }

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
    //app compilers
    kapt(AppDependencies.appCompilers)
    //app libs
    implementation(AppDependencies.appLibraries)
    //test libs
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)
    //domain
    implementation(project(":domain"))
    //data just for di
    implementation(project(":data"))
}