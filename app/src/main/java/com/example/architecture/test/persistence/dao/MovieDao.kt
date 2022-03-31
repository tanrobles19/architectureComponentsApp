package com.example.architecture.test.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.architecture.test.persistence.entity.Movie

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getAllMovies(): List<Movie>

    @Insert
    fun insertNewMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

}