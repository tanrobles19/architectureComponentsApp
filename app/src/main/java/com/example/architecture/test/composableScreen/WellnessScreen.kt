package com.example.architecture.test.composableScreen

import WellnessTasksList
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.architecture.test.composable.StatefulCounter
import com.example.architecture.test.composable.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    //viewModel() returns an existing viewModel or creates a new one in the given scope.
    wellnessViewModel: WellnessViewModel = viewModel()
) {
//    WaterCounter(text = "glasses")
    Column(modifier = modifier) {
        StatefulCounter()

//        val list = remember { getWellnessTasks().toMutableStateList() }

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}