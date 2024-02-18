package com.example.testmission.di

import com.example.testmission.domain.usecase.GetAllBooksUseCase
import com.example.testmission.domain.usecase.impl.GetAllBooksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun getAllUseCaseBinder(impl: GetAllBooksUseCaseImpl): GetAllBooksUseCase
}