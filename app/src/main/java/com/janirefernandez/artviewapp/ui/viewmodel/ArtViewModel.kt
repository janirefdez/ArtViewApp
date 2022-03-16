package com.janirefernandez.artviewapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janirefernandez.artviewapp.data.model.Record
import com.janirefernandez.artviewapp.domain.GetMuseumObjectsUseCase
import kotlinx.coroutines.launch

class ArtViewModel : ViewModel() {

    val artModelList = MutableLiveData<MutableList<Record>>()

    var getObjectUseCase = GetMuseumObjectsUseCase()

    fun onCreate() {
        viewModelScope.launch {
            val result = getObjectUseCase()
            if (!result.isNullOrEmpty()) {
                if(!artModelList.value.isNullOrEmpty()){
                    artModelList.value!!.addAll(result)
                    artModelList.postValue(artModelList.value)
                } else {
                    artModelList.postValue(result.toMutableList())
                }
            }
        }
    }
}