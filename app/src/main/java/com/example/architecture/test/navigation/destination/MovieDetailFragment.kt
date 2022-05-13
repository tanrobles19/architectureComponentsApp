package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.architecture.test.R
import com.example.architecture.test.databinding.MovieDetailLayoutBinding

class MovieDetailFragment : Fragment() {

    private lateinit var _binding : MovieDetailLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View {
        _binding = MovieDetailLayoutBinding.inflate(inflater, container, false)

        val safeArgs: MovieDetailFragmentArgs by navArgs()
        println(safeArgs.movieID)

        "MovieId: ${safeArgs.movieID}".also { _binding.movieDetailTitle.text = it }

        return _binding.root
    }

}
