package com.example.template.data.remote.api

import com.example.template.data.common.ServerResponse
import com.example.template.data.remote.dto.request.SampleReqDTO
import com.example.template.data.remote.dto.response.SampleResDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SampleApi {

    @POST("endpoint")
    suspend fun setSample(
        @Body body: SampleReqDTO
    ): Response<ServerResponse<SampleResDTO>>

    @GET("endpoint")
    suspend fun getSamples(
    ): Response<ServerResponse<List<SampleResDTO>>>

}