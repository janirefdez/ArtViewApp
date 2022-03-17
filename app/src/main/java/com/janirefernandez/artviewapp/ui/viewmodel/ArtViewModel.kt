package com.janirefernandez.artviewapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.domain.GetMuseumObjectsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtViewModel @Inject constructor(
    private val getMuseumObjectsUseCase: GetMuseumObjectsUseCase
) : ViewModel() {

    val artModelList = MutableLiveData<MutableList<Record>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMuseumObjectsUseCase()
            if (!result.isNullOrEmpty()) {
                artModelList.postValue(result.toMutableList())
                isLoading.postValue(false)
            }
        }
    }
}