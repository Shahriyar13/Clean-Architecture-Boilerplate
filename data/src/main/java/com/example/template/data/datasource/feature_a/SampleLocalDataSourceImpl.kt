package com.example.template.data.datasource.feature_a

import com.example.template.data.locale.dao.SampleDao
import com.example.template.data.mapper.feature_a.map
import com.example.template.domain.entity.feature_a.SampleEntity

class SampleLocalDataSourceImpl(
    private val sampleDao: SampleDao,
): SampleLocalDataSource {
    override suspend fun setSample(sampleEntity: SampleEntity) {
        sampleDao.insert(sampleEntity.map())

    }

    override suspend fun setSample(sampleEntities: List<SampleEntity>) {
        sampleDao.insert(sampleEntities.map { it.map() }.toList())
    }

    override suspend fun deleteAll() {
        sampleDao.truncate()
    }

    override suspend fun getSample(): List<SampleEntity> {
        return sampleDao.select()?.map { it.map() }?.toList() ?: listOf()
    }
}