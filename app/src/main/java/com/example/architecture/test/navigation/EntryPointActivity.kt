package com.example.architecture.test.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecture.test.R
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

class EntryPointActivity : AppCompatActivity() {

    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val addMovie = findViewById<Button>(R.id.addNewMovieButton)
//
//        addMovie.setOnClickListener {
//            addNewMovie()
//        }
//
//        val movieDao  = AppDataBase.getInstance(applicationContext).movieDao()
//        this.movieViewModel = MovieViewModel(movieDao)

    }

    fun addNewMovie() {

        val movie = Movie("Matrix", "description text")

        this.movieViewModel.createNewMovie(movie)

    }

}