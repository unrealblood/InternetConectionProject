package com.strength.internetconectionproject.fragments.home_screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeScreenViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            return HomeScreenViewModel(application) as T
        }

        throw IllegalArgumentException("Unable to create HomeScreenViewModel class from HomeScreenViewModelFactory")
    }
}