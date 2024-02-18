package com.example.testmission.presenter.details


sealed interface DetailsScreenContract {
    interface ViewModel{
        fun onEventDispatcher(intent: DetailsScreenContract.Intent)
    }
    interface Intent {
        object BackToHomeScreen : Intent
    }
}