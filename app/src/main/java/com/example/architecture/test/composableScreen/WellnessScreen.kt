package com.example.architecture.test.composableScreen

import WellnessTasksList
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.architecture.test.composable.StatefulCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
//    WaterCounter(text = "glasses")
    Column(modifier = modifier) {
        StatefulCounter()
        WellnessTasksList()
    }
}