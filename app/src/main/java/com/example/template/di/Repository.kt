package com.example.template.di

import com.example.template.data.datasource.feature_a.SampleLocalDataSource
import com.example.template.data.datasource.feature_a.SampleRemoteDataSource
import com.example.template.data.repository.feature_a.SampleRepositoryImpl
import com.example.template.domain.repository.feature_a.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Repository {

    @Provides
    @Singleton
    fun provideSampleRepository(
        localDataSource: SampleLocalDataSource,
        remoteDataSource: SampleRemoteDataSource
    ): SampleRepository
    = SampleRepositoryImpl(localDataSource, remoteDataSource)

}