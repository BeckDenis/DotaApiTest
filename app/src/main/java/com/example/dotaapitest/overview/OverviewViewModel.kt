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

enum class DotaApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent status
    private val _status = MutableLiveData<DotaApiStatus>()

    private val viewmodelJob = Job()

    private val coroutineScope = CoroutineScope(viewmodelJob + Dispatchers.Main)

    // The external immutable LiveData for the status String
    val status: LiveData<DotaApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<DotaProperty>>()

    val properties: LiveData<List<DotaProperty>>
        get() = _properties

    /**
     * Call getDotaHeroesProperties() on init so we can display status immediately.
     */
    init {
        getDotaHeroesProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getDotaHeroesProperties() {
        coroutineScope.launch {
            var getPropertisDeferred = DotaApi.retrofitService.getProperties()
            try {
                _status.value = DotaApiStatus.LOADING
                val listResult = getPropertisDeferred.await()
                _status.value = DotaApiStatus.DONE
                _properties.value = listResult
            } catch (e: Exception) {
                _status.value = DotaApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    private val _navigateToSelectedProperty = MutableLiveData<DotaProperty>()
    val navigateToSelectedProperty: LiveData<DotaProperty>
        get() = _navigateToSelectedProperty

    fun displayPropertyDetails(marsProperty: DotaProperty) {
        _navigateToSelectedProperty.value = marsProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewmodelJob.cancel()
    }
}
