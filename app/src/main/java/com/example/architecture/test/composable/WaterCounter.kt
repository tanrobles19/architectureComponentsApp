package com.example.architecture.test.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * It's good practice to provide a modifier for all the composable functions, as it increases reusability.
 */

@Composable
fun WaterCounter(modifier: Modifier = Modifier, text: String) {

    Column(modifier = modifier.padding(16.dp)) {

//        val count: MutableState<Int> = remember {mutableStateOf(0)}

        var count by remember { mutableStateOf(0) }

        if(count > 0) {

            var showTask by remember { mutableStateOf(true) }
            if(showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken yout 15 minutes walk today"
                )
            }
            Text(text = "You 've had $count $text")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10
            ) {
                Text(text = "Click me!")
            }
            Button(
                onClick = { count = 0 }, Modifier.padding(start = 8.dp),
                enabled = count < 10
            ) {
                Text(text = "Clear water count")
            }

        }

    }// end Column

}// end composable fun

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Composable
fun StatelessCounter( count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if(count > 0) {
            Text(text = "You 've had $count glasses")
        }
        Button(
            onClick = onIncrement ,
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }
}// end fun StatelessCounter

@Preview(showBackground = true, name = "Preview test")
@Composable
fun Preview() {
    WaterCounter(text = "Glasses")
}