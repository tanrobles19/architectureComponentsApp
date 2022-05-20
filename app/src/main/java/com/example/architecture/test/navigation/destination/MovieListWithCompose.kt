package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class MovieListWithCompose : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup ?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Greeting("Fragment Entry Point")
            }
        }
    }

    @Preview(showBackground = true, name = "Text Preview")
    @Composable
    fun DefaultPreview() {
        Surface(color = MaterialTheme.colors.primary) {
            TestList()
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
    private fun Greeting( name: String) {
        Text(
            text = name,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}