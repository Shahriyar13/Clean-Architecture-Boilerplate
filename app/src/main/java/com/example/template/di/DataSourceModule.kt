package com.example.template.di

import com.example.template.data.datasource.feature_a.SampleLocalDataSource
import com.example.template.data.datasource.feature_a.SampleLocalDataSourceImpl
import com.example.template.data.datasource.feature_a.SampleRemoteDataSource
import com.example.template.data.datasource.feature_a.SampleRemoteDataSourceImpl
import com.example.template.data.locale.dao.SampleDao
import com.example.template.data.remote.api.SampleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideSampleLocalDataSource(sampleDao: SampleDao): SampleLocalDataSource =
        SampleLocalDataSourceImpl(sampleDao)

    @Provides
    @Singleton
    fun provideSampleRemoteDataSource(sampleApi: SampleApi): SampleRemoteDataSource =
        SampleRemoteDataSourceImpl(sampleApi)

}