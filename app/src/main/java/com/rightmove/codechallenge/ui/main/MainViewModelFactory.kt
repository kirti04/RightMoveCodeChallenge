package com.rightmove.codechallenge.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rightmove.library_property.domain.usecase.GetPropertiesUseCase
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(getPropertiesUseCase) as T
}