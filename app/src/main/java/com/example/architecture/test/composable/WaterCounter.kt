package com.example.architecture.test.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * It's good practice to provide a modifier for all the composable functions, as it increases reusability.
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier, text: String) {
    val count = 0
    Text(modifier = modifier.padding(16.dp), text = "You 've had $count $text")
}