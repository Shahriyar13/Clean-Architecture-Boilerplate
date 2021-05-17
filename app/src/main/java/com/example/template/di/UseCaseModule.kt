package com.example.template.di

import com.example.template.data.usecase.feature_a.SampleUseCaseImpl
import com.example.template.domain.repository.feature_a.SampleRepository
import com.example.template.domain.usecase.feature_a.SampleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSampleUseCase(
        sampleRepository: SampleRepository
    ): SampleUseCase = SampleUseCaseImpl(sampleRepository)

}