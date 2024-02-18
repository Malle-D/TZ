package com.example.testmission.presenter.home

import com.example.testmission.data.model.simple.BookModel
import kotlinx.coroutines.flow.StateFlow

sealed interface HomeScreenContract {

    interface ViewModel {
        val uiState : StateFlow<UiState>
        fun onEventDispatcher(intent: Intent)
    }

    data class UiState(
        val isLoading : Boolean = false,
        val data : List<BookModel> = emptyList()
    )

    interface Intent{
        data class Details(
            val data : BookModel
        ) : Intent
    }

}