package com.strength.internetconectionproject.fragments.home_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.strength.internetconectionproject.network.MarsApi
import com.strength.internetconectionproject.network.MarsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.await

class HomeScreenViewModel(private val application: Application) : AndroidViewModel(application) {
    private val _responseLiveDataString = MutableLiveData<String>()
    val response : LiveData<String>
        get() = _responseLiveDataString

    private val _marsDataList = MutableLiveData<List<MarsData>>()
    val marsData : LiveData<List<MarsData>>
        get() = _marsDataList

    private var homeScreenViewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + homeScreenViewModelJob)

    init {
        getMarsRealestateProperties()
    }

    private fun getMarsRealestateProperties() {
        _responseLiveDataString.value = "Getting data from the internet\n\n"

        uiScope.launch {
            var getPropertiesDeferred = MarsApi.retrofitService.getProperties()

            try {
                var marsDataList = getPropertiesDeferred.await()

                /*if(marsDataList.size > 0) {
                    _marsDataList.value = marsDataList
                }*/

                _responseLiveDataString.value = "Mars data successfully retrived."
            }
            catch (exception : Throwable) {
                _responseLiveDataString.value = "Failed to retrive mars data. " + exception.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()

        homeScreenViewModelJob.cancel()
    }
}