package com.example.template.domain.usecase.feature_a

import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity
import com.example.template.domain.usecase.BaseUseCase

interface SampleUseCase: BaseUseCase {
    suspend fun saveSample(sampleEntity: SampleEntity)
    suspend fun getSamples(): MResult<List<SampleEntity>>
}