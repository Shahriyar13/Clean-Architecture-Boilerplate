package com.example.template.data.usecase.feature_a

import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity
import com.example.template.domain.repository.feature_a.SampleRepository
import com.example.template.domain.usecase.feature_a.SampleUseCase

class SampleUseCaseImpl(
    private val sampleRepository: SampleRepository
): SampleUseCase {
    override suspend fun saveSample(sampleEntity: SampleEntity) {
        sampleRepository.setData(sampleEntity)
    }

    override suspend fun getSamples(): MResult<List<SampleEntity>> {
        return sampleRepository.getData()
    }
}