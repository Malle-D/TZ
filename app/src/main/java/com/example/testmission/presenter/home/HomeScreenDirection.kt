package com.example.testmission.presenter.home

import com.example.testmission.data.model.simple.BookModel
import com.example.testmission.presenter.details.DetailsScreen
import com.example.testmission.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface HomeScreenDirection {
    suspend fun moveToDetailsScreen(bookModel: BookModel)
}

@Singleton
class HomeScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : HomeScreenDirection {
    override suspend fun moveToDetailsScreen(bookModel: BookModel) {
        appNavigator.addScreen(DetailsScreen(bookModel))
    }
}