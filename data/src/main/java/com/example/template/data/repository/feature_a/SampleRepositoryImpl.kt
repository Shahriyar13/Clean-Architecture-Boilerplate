package com.example.template.data.repository.feature_a

import com.example.template.data.datasource.feature_a.SampleLocalDataSource
import com.example.template.data.datasource.feature_a.SampleRemoteDataSource
import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity
import com.example.template.domain.repository.feature_a.SampleRepository

class SampleRepositoryImpl(
    private val localDataSource: SampleLocalDataSource,
    private val remoteDataSource: SampleRemoteDataSource
): SampleRepository {

    override suspend fun setData(sampleEntity: SampleEntity) {
        localDataSource.setSample(sampleEntity)
    }

    override suspend fun getData(): MResult<List<SampleEntity>> {
        val res = remoteDataSource.getSample()
        if (res is MResult.Success) {
            if (res.data != null)
                localDataSource.setSample(res.data!!)
        }
        return res
    }
}