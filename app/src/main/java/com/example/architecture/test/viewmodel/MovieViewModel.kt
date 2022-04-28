package com.example.architecture.test.viewmodel

import androidx.lifecycle.ViewModel
import com.example.architecture.test.persistence.dao.MovieDao
import com.example.architecture.test.persistence.entity.Movie
import kotlinx.coroutines.*

class MovieViewModel(movieDao: MovieDao) : ViewModel() {

    val dao = movieDao

    val movieList = dao.getAllMovies()

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun createNewMovie( movie: Movie) {

        uiScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                dao.insertNewMovie(movie)
            }
        }

//            dao.insertNewMovie(movie)


    }// end createNewMovie fun

}