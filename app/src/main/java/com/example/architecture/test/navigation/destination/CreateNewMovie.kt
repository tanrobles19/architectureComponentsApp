package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.adapter.MovieAdapter
import com.example.architecture.test.databinding.CreateNewMovieBinding
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

class CreateNewMovie : Fragment() {

    private lateinit var binding : CreateNewMovieBinding

    private lateinit var movieViewModel: MovieViewModel

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = CreateNewMovieBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val movieDao  = AppDataBase.getInstance(application).movieDao()
        this.movieViewModel = MovieViewModel(movieDao)

        binding.createNewMovieButton.setOnClickListener {
            createNewMovie()
        }

        this.movieViewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        adapter = MovieAdapter(this.movieViewModel)

        binding.movieListRecyclerView.adapter = adapter

        return binding.root
    }

    fun createNewMovie() {
        val movie = Movie("Matrix", "description text")
        this.movieViewModel.createNewMovie(movie)
    }

}