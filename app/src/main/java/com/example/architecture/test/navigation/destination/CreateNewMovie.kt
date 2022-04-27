package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.databinding.CreateNewMovieBinding

class CreateNewMovie : Fragment() {

    private lateinit var binding : CreateNewMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CreateNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }
}