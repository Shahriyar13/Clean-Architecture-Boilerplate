package com.example.template.data.remote.dto.response

import com.google.gson.annotations.SerializedName

data class SampleResDTO(
    @SerializedName("Sample")
    val name: String
)