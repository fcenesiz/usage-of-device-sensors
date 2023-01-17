package com.fcenesiz.devicesensors.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()
            val isDark = viewModel.isDark
            val luxValue = viewModel.luxValue
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        if (isDark) Color.DarkGray else Color.White
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(
                        text = if (isDark) "It's dark outside" else "It's bright outside",
                        color = if (isDark) Color.White else Color.DarkGray
                    )
                    Text(
                        text = "Lux: $luxValue",
                        color = if (isDark) Color.White else Color.DarkGray,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

