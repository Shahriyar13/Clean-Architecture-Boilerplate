package com.example.template.ui.feature_a

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.template.base.BaseViewModel
import com.example.template.domain.common.MResult
import com.example.template.domain.entity.feature_a.SampleEntity
import com.example.template.domain.usecase.feature_a.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor(
    private val sampleUseCase: SampleUseCase
): BaseViewModel() {

    @Bindable
    val sampleValue = MutableLiveData<String>()

    private val _sampleLiveData = MutableLiveData<SampleEntity?>()
    val sampleLiveData: LiveData<SampleEntity?> = _sampleLiveData

    private val _sampleListLiveData = MutableLiveData<List<SampleEntity>>()
    val sampleListLiveData: LiveData<List<SampleEntity>> = _sampleListLiveData

    fun save() {
        if (sampleValue.value.isNullOrEmpty()) {
            setErrorMessage("can not be empty")
            return
        }
        _sampleLiveData.value = SampleEntity(sampleValue.value!!)
        viewModelScope.launch(Dispatchers.IO) {
            sampleUseCase.saveSample(sampleLiveData.value!!)
//            _sampleLiveData.postValue(null)
//            withContext(Dispatchers.Main) {
//                _sampleLiveData.value = null
//            }
        }
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = sampleUseCase.getSamples()
//            _sampleListLiveData.postValue()
            withContext(Dispatchers.Main) {
                when (response) {
                    is MResult.Success -> {
                        _sampleListLiveData.value = response.data!!
                    }
                    is MResult.Error -> {
                        setErrorMessage(response.errorMessage)
                    }
                }
            }
        }
    }
}