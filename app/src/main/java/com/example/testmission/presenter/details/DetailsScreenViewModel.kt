package com.example.testmission.presenter.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val detailsScreenDirection: DetailsDirection
): ViewModel(), DetailsScreenContract.ViewModel {
    override fun onEventDispatcher(intent: DetailsScreenContract.Intent) {
        when (intent) {
            DetailsScreenContract.Intent.BackToHomeScreen -> {
                viewModelScope.launch{
                    detailsScreenDirection.backToHome()
                }
            }
        }
    }
}