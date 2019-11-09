package com.example.dotaapitest.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dotaapitest.network.DotaProperty

class DetailViewModel(dotaProperty: DotaProperty, app: Application) : AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<DotaProperty>()
    val selectedProperty: LiveData<DotaProperty>
        get() = _selectedProperty

    init {
        _selectedProperty.value = dotaProperty
    }
}