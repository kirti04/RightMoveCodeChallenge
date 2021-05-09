package com.rightmove.codechallenge.ui.main

import androidx.lifecycle.*
import com.rightmove.codechallenge.ui.extension.formattedString
import com.rightmove.library_property.base.abortOnError
import com.rightmove.library_property.domain.model.Property
import com.rightmove.library_property.domain.usecase.GetPropertiesUseCase
import kotlinx.coroutines.launch

internal class MainViewModel(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _averagePrice = MutableLiveData<String>()
    val averagePrice: LiveData<String> = _averagePrice

    fun onStart() {
        viewModelScope.launch {
            _isLoading.value = true
            updateUi()
            _isLoading.value = false
        }
    }

    private suspend fun updateUi() {
        _averagePrice.value = getProperties().let { properties ->
            if (properties.isNotEmpty()) {
                properties.map { it.price }.average().formattedString
            } else {
                "Api error"
            }
        }
    }

    private suspend fun getProperties(): List<Property> =
        getPropertiesUseCase.invoke().abortOnError { return emptyList() }
}