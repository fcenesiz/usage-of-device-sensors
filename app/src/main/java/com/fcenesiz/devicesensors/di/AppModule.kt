package com.fcenesiz.devicesensors.di

import android.app.Application
import com.fcenesiz.devicesensors.sensor.LightSensor
import com.fcenesiz.devicesensors.sensor.MeasurableSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLightSensor(app: Application): MeasurableSensor{
        return LightSensor(app)
    }

}