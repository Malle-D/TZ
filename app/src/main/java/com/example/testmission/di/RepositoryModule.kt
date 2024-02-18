package com.example.testmission.di

import com.example.testmission.domain.repository.AppRepository
import com.example.testmission.domain.repository.impl.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun repositoryBinder(impl: AppRepositoryImpl): AppRepository
}