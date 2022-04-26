package com.example.architecture.test.navigation.destination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.architecture.test.databinding.FragmentMainBinding
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

class MainFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = _binding.root

        val addMovie = _binding.addNewMovieButton

        addMovie.setOnClickListener {
            addNewMovie()
        }

        val application = requireNotNull(this.activity).application
        val movieDao  = AppDataBase.getInstance(application).movieDao()
        this.movieViewModel = MovieViewModel(movieDao)

        return view

    }

    fun addNewMovie() {
        val movie = Movie("Matrix", "description text")
        this.movieViewModel.createNewMovie(movie)
    }

}