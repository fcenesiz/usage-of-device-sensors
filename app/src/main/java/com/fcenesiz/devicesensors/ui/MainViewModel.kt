package com.fcenesiz.devicesensors.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.fcenesiz.devicesensors.sensor.LightSensor
import com.fcenesiz.devicesensors.sensor.MeasurableSensor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val lightSensor: MeasurableSensor
) : ViewModel() {

    var isDark by mutableStateOf(false)
    var luxValue by mutableStateOf(0f)

    init {
        lightSensor.startListening()
        lightSensor.setOnSensorValuesChangedListener { values ->
            val lux = values[0]
            luxValue = lux
            isDark = lux < 60f
        }
    }

}