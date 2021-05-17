package com.example.template.ui.home

import com.example.template.base.BaseViewModel
import com.example.template.common.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel() {

    val navigateToFeatureA = SingleLiveEvent<Unit>()

    fun nextMoveSelected() {
        navigateToFeatureA.call()
    }
}