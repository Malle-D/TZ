package com.example.testmission.domain.repository

import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.response.AppResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getAllBooks(request: AppRequest) : Flow<Result<AppResponse>>
}