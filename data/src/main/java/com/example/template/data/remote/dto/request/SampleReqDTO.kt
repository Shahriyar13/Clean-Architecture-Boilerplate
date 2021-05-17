package com.example.template.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class SampleReqDTO(
    @SerializedName("Sample")
    val name: String
)