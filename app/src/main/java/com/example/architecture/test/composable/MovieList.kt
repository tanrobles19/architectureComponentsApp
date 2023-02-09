package com.example.architecture.test.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.architecture.test.composable.model.WellnessTask
import com.example.architecture.test.persistence.entity.Movie

@Composable
fun MovieList(
    list: List<Movie>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(
            items = list,
            key = { movie -> movie.id!! }
        ) { movie ->
            MovieItem(movieName = movie.name, checked =false, onCheckedChange ={})
        }
    }
}