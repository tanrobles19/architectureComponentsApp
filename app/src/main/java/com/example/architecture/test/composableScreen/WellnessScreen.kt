package com.example.architecture.test.composableScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.architecture.test.composable.StatefulCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
//    WaterCounter(text = "glasses")
    StatefulCounter()
}