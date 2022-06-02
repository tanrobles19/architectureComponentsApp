package com.example.architecture.test.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * It's good practice to provide a modifier for all the composable functions, as it increases reusability.
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier, text: String) {

    Column(modifier = modifier.padding(16.dp)) {

        val count: MutableState<Int> = remember {mutableStateOf(0)}

        Text(text = "You 've had ${count.value} $text")
        Button(
            onClick = { count.value++ }
        ) {
            Text(text = "Click me!")
        }
    }

}// end composable fun

@Preview(showBackground = true, name = "Preview test")
@Composable
fun Preview() {
    WaterCounter(text = "Glasses")
}