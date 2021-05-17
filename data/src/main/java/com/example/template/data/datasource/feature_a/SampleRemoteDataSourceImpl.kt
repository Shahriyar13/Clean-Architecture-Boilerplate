package com.example.template.data.datasource.feature_a

import com.example.template.data.common.Converter
import com.example.template.data.mapper.feature_a.map
import com.example.template.data.remote.api.SampleApi
import com.example.template.data.remote.dto.request.SampleReqDTO
import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity

class SampleRemoteDataSourceImpl(
    private val sampleApi: SampleApi
): SampleRemoteDataSource {
    override suspend fun setSample(sampleEntity: SampleEntity): MResult<Boolean> {
        val res = sampleApi.setSample(SampleReqDTO(sampleEntity.name ?: ""))
        return when (val result =
            Converter.createFromResponse(res)) {
            is MResult.Success -> {
                MResult.Success(true)
            }
            is MResult.SuccessEmpty -> MResult.SuccessEmpty()
            is MResult.Error -> MResult.Error(result.errorMessage)
            else -> MResult.Error("Unknown")
        }
    }

    override suspend fun getSample(): MResult<List<SampleEntity>> {
        val res = sampleApi.getSamples()
        return when (val result =
            Converter.createFromResponse(res)) {
            is MResult.Success -> {
                MResult.Success(result.data?.map{it.map()}?.toList() ?: listOf())
            }
            is MResult.SuccessEmpty -> MResult.SuccessEmpty()
            is MResult.Error -> MResult.Error(result.errorMessage)
            else -> MResult.Error("Unknown")
        }
    }

}