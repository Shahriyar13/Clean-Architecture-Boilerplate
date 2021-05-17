import org.gradle.api.artifacts.dsl.DependencyHandler

object BuildPlugins {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildGradleVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val daggerHiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val navigationSafeArgsPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
}

object Versions {
    //app level
    const val buildGradleVersion = "4.0.0"
    const val gradleVersion = "4.1.0"
    const val kotlinVersion = "1.4.32"
    const val hiltVersion = "2.34.1-beta"

    const val googleServiceVersion = "4.3.5"
    const val firebaseCrashlyticsVersion = "2.5.1"
    const val firebasePerformanceVersion = "1.3.4"

    //libs
    const val coreKtxVersion = "1.3.2"
    const val appcompatVersion = "1.2.0"
    const val constraintLayoutVersion = "2.0.4"
    const val materialVersion = "1.3.0"
    const val swipeRefreshVersion = "1.1.0"
    const val lifeCycleVersion = "2.3.1"
    const val navigationVersion = "2.3.5"
    const val navigationComposeVersion = "1.0.0-alpha10"
    const val hiltLifeCycleVersion = "1.0.0-alpha02"
    const val roomVersion = "2.3.0"
    const val glideVersion = "4.11.0"
    const val retrofitVersion = "2.6.2"
    const val loggingInterceptorVersion = "4.7.2"
    const val cameraVersion = "1.0.0-beta06"
    const val cameraExtensionsVersion = "1.0.0-alpha11"
    const val multiDexVersion = "2.0.1"
    const val workManagerVersion = "2.4.0"

    //test
    const val junitVersion = "4.12"
    const val extJunitVersion = "1.1.2"
    const val espressoVersion = "3.3.0"
}

object AppConfig {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val proguardConsumerRules = "consumer-rules.pro"
    const val dimension = "environment"

    object BuildTypes {
        const val release = "release"
        const val debug = "debug"
    }

    object ProductFlavors {
        const val staging = "staging"
        const val production = "production"
    }
}

object AppDependencies {

    // std libraries
    private const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"

    // android ui libraries
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompatVersion}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    private const val material = "com.google.android.material:material:${Versions.materialVersion}"
    private const val swipeRefresh = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshVersion}"

    // dependency injection libraries
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    private const val hiltAndroidCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    private const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifeCycleVersion}"
    private const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltLifeCycleVersion}"

    // lifecycle libraries
    private const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycleVersion}"
    private const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycleVersion}"
    private const val lifecycleViewExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleVersion}"
    private const val lifecycleViewReactiveStream = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.lifeCycleVersion}"

    // navigation component libraries
    private const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
    private const val navigationDynamicFeatures = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navigationVersion}"
    private const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationComposeVersion}"

    // image loader libraries
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    private const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    // database orm libraries
    private const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    private const val room = "androidx.room:room-ktx:${Versions.roomVersion}"
    private const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"

    // rest-full api libraries
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    private const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"

    // camera2
    private const val camera2 = "androidx.camera:camera-camera2:${Versions.cameraVersion}"
    private const val cameraLifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraVersion}"
    private const val cameraView = "androidx.camera:camera-view:${Versions.cameraExtensionsVersion}"
    private const val cameraExtensions = "androidx.camera:camera-extensions:${Versions.cameraExtensionsVersion}"

    //extra libraries
    private const val multiDex = "androidx.multidex:multidex:${Versions.multiDexVersion}"
    private const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"

    // test libraries
    private const val junit = "junit:junit:${Versions.junitVersion}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(swipeRefresh)
        add(lifecycleLiveData)
        add(lifecycleViewModel)
//        add(lifecycleViewExtensions)
//        add(lifecycleViewReactiveStream)
        add(hiltAndroid)
//        add(hiltLifecycleViewModel)
        add(glide)
        add(roomRuntime)
        add(room)
        add(retrofit)
        add(retrofitGson)
        add(loggingInterceptor)
        add(navigationFragment)
        add(navigationUi)
        add(navigationDynamicFeatures)
        add(navigationCompose)

//        add(camera2)
//        add(cameraLifecycle)
//        add(cameraView)
//        add(cameraExtensions)

//        add(workManager)
    }

    val appCompilers = arrayListOf<String>().apply {
        add(hiltAndroidCompiler)
        add(hiltCompiler)
        add(glideCompiler)
        add(roomCompiler)
    }

    val domainLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
    }

    val dataLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(coreKtx)
        add(retrofit)
        add(retrofitGson)
        add(roomRuntime)
        add(room)
    }

    val dataCompilers = arrayListOf<String>().apply {
        add(roomCompiler)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}