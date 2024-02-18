package com.example.testmission.domain.usecase

import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.response.AppResponse
import com.example.testmission.data.model.simple.BookModel
import kotlinx.coroutines.flow.Flow

interface GetAllBooksUseCase {
    fun getAllBooks(request: AppRequest) : Flow<Result<AppResponse>>
}