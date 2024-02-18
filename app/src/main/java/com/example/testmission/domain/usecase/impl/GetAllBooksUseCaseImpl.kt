package com.example.testmission.domain.usecase.impl

import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.response.AppResponse
import com.example.testmission.domain.repository.AppRepository
import com.example.testmission.domain.usecase.GetAllBooksUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllBooksUseCaseImpl @Inject constructor(
    private val appRepository: AppRepository
) : GetAllBooksUseCase {
    override fun getAllBooks(request: AppRequest): Flow<Result<AppResponse>> = appRepository.getAllBooks(request)

}