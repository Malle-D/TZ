package com.example.testmission.domain.repository.impl

import android.util.Log
import com.example.testmission.data.api.Api
import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.response.AppResponse
import com.example.testmission.domain.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appApi: Api
) : AppRepository {
    override fun getAllBooks(request: AppRequest): Flow<Result<AppResponse>> = flow {
        val response = appApi.getAllBooks(request, "Bearer bGlmZXN0eWxlOjY0YzBkMGZlYzcwOGU1MDYyMWViZDMxNA==")
        if (response.isSuccessful && response.body() != null) {
            emit(Result.success(response.body()!!))
        } else {
            emit(Result.failure(IllegalArgumentException("error")))
        }
    }.catch { emit(Result.failure(it)) }
        .flowOn(Dispatchers.IO)
}