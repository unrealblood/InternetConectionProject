package com.strength.internetconectionproject.fragments.detail_fragment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PhotoDetailViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PhotoDetailViewModel::class.java)) {
            return PhotoDetailViewModel(application) as T
        }

        throw IllegalArgumentException("Error creating photo detail view model from factory class.")
    }
}