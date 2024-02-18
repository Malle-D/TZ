package com.example.testmission.data.api


import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.response.AppResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface Api {

    @POST("new/")
    suspend fun getAllBooks(
        @Body request: AppRequest,
        @Header("Authorization") token : String,
    ): Response<AppResponse>

}