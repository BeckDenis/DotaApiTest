package com.example.dotaapitest.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dotaapitest.network.DotaApi
import com.example.dotaapitest.network.DotaProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    private val viewmodelJob = Job()

    private val coroutineScope = CoroutineScope(viewmodelJob + Dispatchers.Main)

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    private val _properties = MutableLiveData<List<DotaProperty>>()

    val properties: LiveData<List<DotaProperty>>
        get() = _properties

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
        coroutineScope.launch {
            var getPropertisDeferred = DotaApi.retrofitService.getProperties()
            try {
                val listResult = getPropertisDeferred.await()
                _response.value = "Success: ${listResult.size} Mars properties retrieved"
                _properties.value = listResult
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancel()
    }
}
