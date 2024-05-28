package com.developerspace.webrtcsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TouchViewModel : ViewModel() {

    var localTouchPoints = MutableLiveData<List<TouchPoint>>()
        private set

    var remoteTouchPoints = MutableLiveData<List<TouchPoint>>()
        private set

    fun updateLocalTouchPoints(points: List<TouchPoint>) {
        localTouchPoints.value = points
    }

    fun updateRemoteTouchPoints(points: List<TouchPoint>) {
        remoteTouchPoints.value = points
    }
}