package com.example.testmission.presenter.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmission.data.model.request.AppRequest
import com.example.testmission.data.model.simple.BookModel
import com.example.testmission.domain.repository.AppRepository
import com.example.testmission.domain.usecase.GetAllBooksUseCase
import com.example.testmission.utils.mapper.toSimple
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val gelAllBooksUseCase: GetAllBooksUseCase,
    private val direction: HomeScreenDirection
) : HomeScreenContract.ViewModel, ViewModel() {
    init {
        loadData()
    }

    override val uiState = MutableStateFlow(HomeScreenContract.UiState(true, emptyList()))
    override fun onEventDispatcher(intent: HomeScreenContract.Intent) {
        when (intent) {
            is HomeScreenContract.Intent.Details -> {
                viewModelScope.launch {
                    direction.moveToDetailsScreen(intent.data)
                }
            }
        }
    }

    private fun loadData() {
        gelAllBooksUseCase.getAllBooks(AppRequest(178))
//            .onStart { uiState.update { it.copy(isLoading = true, data = emptyList()) } }
            .onEach { it ->
                it.onSuccess { ls ->
                    val list = mutableListOf<BookModel>()
                    list.addAll(ls.data.books.map { it.toSimple() })
                    uiState.update { it.copy(data = list, isLoading = false) }
                }
            }
//            .onCompletion { uiState.update { it.copy(isLoading = false) } }
            .launchIn(viewModelScope)
    }
}