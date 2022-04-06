package com.example.architecture.test.navigation.destination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.architecture.test.R
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val addMovie = this.activity?.findViewById<Button>(R.id.addNewMovieButton)

        addMovie?.setOnClickListener {
            addNewMovie()
        }

        val application = requireNotNull(this.activity).application
        val movieDao  = AppDataBase.getInstance(application).movieDao()
        this.movieViewModel = MovieViewModel(movieDao)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    fun addNewMovie() {
        val movie = Movie("Matrix", "description text")
        this.movieViewModel.createNewMovie(movie)
    }

}