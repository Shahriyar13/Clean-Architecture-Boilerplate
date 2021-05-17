package com.example.template.data.common

import com.example.template.domain.common.MResult
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

object Converter {

    /** use this if server response data modified into an object like "data" **/
    fun <T> createFromResponse(response: Response<ServerResponse<T>>): MResult<T> {
        return if (response.isSuccessful) {
            val body = response.body()
            if (body?.data != null) {
                MResult.Success(body.data)
            } else if (response.code() in 200..204 || (body != null && body.data == null)) {
                MResult.SuccessEmpty()
            } else {
                MResult.Error(body?.toString() ?: "try again later")
            }
        } else {
            return try {
                val reader = JSONObject((response.errorBody() as ResponseBody).string())
                val errorMessage = reader.getJSONArray("Messages")[0]?.toString()
                MResult.Error(errorMessage ?: "Error")
            } catch (e: JSONException) {
                e.printStackTrace()
                MResult.Error("unknown error")
            }
        }
    }
}

