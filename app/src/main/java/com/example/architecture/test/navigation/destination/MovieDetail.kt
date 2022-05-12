package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.databinding.MovieDetailLayoutBinding

class MovieDetail : Fragment() {

    private lateinit var _binding : MovieDetailLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View? {
        _binding = MovieDetailLayoutBinding.inflate(inflater, container, false)

        return _binding.root
    }

}