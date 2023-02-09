package com.example.architecture.test.composableScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.architecture.test.composable.MovieList
import com.example.architecture.test.composable.StatefulCounter
import com.example.architecture.test.viewmodel.MovieViewModel

@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    movieViewModel: MovieViewModel = viewModel()
) {

    var count by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        StatefulCounter()
        MovieList(list = movieViewModel.movieList)
    }
}