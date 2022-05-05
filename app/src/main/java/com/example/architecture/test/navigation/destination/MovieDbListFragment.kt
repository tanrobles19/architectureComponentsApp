package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.databinding.MovieListLayoutBinding

class MovieDbListFragment : Fragment() {

    private lateinit var _binding : MovieListLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View {
        _binding = MovieListLayoutBinding.inflate(inflater, container, false)
        return _binding.root
    }

}