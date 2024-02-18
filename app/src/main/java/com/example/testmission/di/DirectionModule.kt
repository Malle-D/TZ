package com.example.testmission.di

import com.example.testmission.presenter.details.DetailsDirection
import com.example.testmission.presenter.details.DetailsDirectionImpl
import com.example.testmission.presenter.home.HomeScreenDirection
import com.example.testmission.presenter.home.HomeScreenDirectionImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun bindsHomeScreenDirection(impl : HomeScreenDirectionImpl) : HomeScreenDirection

    @Binds
    fun bindDetailsScreenDirection(impl : DetailsDirectionImpl) : DetailsDirection
}