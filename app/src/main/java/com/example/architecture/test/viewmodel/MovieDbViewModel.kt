package com.example.architecture.test.viewmodel

import androidx.lifecycle.ViewModel
import com.example.architecture.test.themoviedb.model.Result

class MovieDbViewModel(movieDbList: List<Result>) : ViewModel() {

    val movieDbList = movieDbList

}