package com.example.template.data.mapper.feature_a

import com.example.template.data.locale.entity.SampleData
import com.example.template.data.remote.dto.response.SampleResDTO
import com.example.template.domain.entity.feature_a.SampleEntity

fun SampleEntity.map() = SampleData(
//    id = 0,
    name = name ?: ""
)
fun SampleData.map() = SampleEntity(
    name = name,
)
fun SampleResDTO.map() = SampleEntity(
    name = name
)