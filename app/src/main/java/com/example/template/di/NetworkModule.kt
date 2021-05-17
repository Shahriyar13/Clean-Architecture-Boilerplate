package com.example.template.di

import androidx.viewbinding.BuildConfig
import com.example.template.data.remote.api.SampleApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url
                val urlBuilder = originalHttpUrl.newBuilder()

//                val sslPinning = CertificatePinner.Builder()
//                    .add("HOST_PATTERN", "SSL_PIN")
//                    .build()
//

                val requestBuilder = original.newBuilder()
                    .url(urlBuilder.build())

                //add header
//                requestBuilder.addHeader(
//                    "x-access-token",
//                    "3a6bc011ff43920fc5e014cf1846cdaf"
//                )

                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .serializeNulls()
            .enableComplexMapKeySerialization()
            .setLenient()
            .create()


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl("https://google.com/")
        .build()

    @Provides
    @Singleton
    fun provideSampleApi(retrofit: Retrofit): SampleApi =
        retrofit.create(SampleApi::class.java)

}