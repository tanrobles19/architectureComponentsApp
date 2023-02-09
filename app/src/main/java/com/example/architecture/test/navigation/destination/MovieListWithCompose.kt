package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.architecture.test.composableScreen.MovieScreen
import com.example.architecture.test.composableScreen.WellnessScreen

class MovieListWithCompose : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup ?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
//                BuildList()
//                WellnessScreen()
                MovieScreen()
            }
        }
    }

    @Preview(showBackground = true, name = "Text Preview")
    @Composable
    fun DefaultPreview() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
//            BuildList()
            MovieScreen()
        }
    }
    @Composable
    fun TestList(names: List<String> = listOf("Eithan", "Issac", "Lu", "Jonathan")) {
        Column(modifier = Modifier.padding(24.dp)){
            for (name in names) {
                Text(text = "Hello")
                Text(text = name)
            }
        }
    }
    
    @Composable
    fun BuildList(names: List<String> = List(1000) {"$it"} ){
        LazyColumn(modifier = Modifier.padding(vertical = 8.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }

    @Composable
    private fun Greeting(name: String) {

        val expanded = rememberSaveable { mutableStateOf(false) }

        val extraPadding = if (expanded.value) 48.dp else 0.dp

        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
                ) {
                    Text(text = "Hello, ")
                    Text(text = name)
                }
                OutlinedButton(
                    onClick = { expanded.value = !expanded.value }
                ) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }
        }
    }// end Composable Greeting()

}