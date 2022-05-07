package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.adapter.MovieDbAdapter
import com.example.architecture.test.application.TestApplication
import com.example.architecture.test.databinding.MovieListLayoutBinding
import com.example.architecture.test.themoviedb.model.Result
import com.example.architecture.test.themoviedb.model.Success
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieDbListFragment : Fragment() {

    private lateinit var _binding : MovieListLayoutBinding

    private val remoteApi = TestApplication.remoteApi

    private val viewModelJob = Job()

//    private lateinit var movieDbViewModel: MovieDbViewModel
    private lateinit var adapter : MovieDbAdapter

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View {
        _binding = MovieListLayoutBinding.inflate(inflater, container, false)

        getMovieList()

        return _binding.root
    }

    private fun loadData(movieDbList : List<Result>) {

        CoroutineScope(Dispatchers.Main).launch {
            adapter = MovieDbAdapter(movieDbList)
            _binding.recyclerViewMovieList.adapter = adapter
            adapter.submitList(movieDbList)
        }

    }// end fun loadData()

    private fun getMovieList() {
        uiScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val movieList = remoteApi.getAudioBookInfoSynchronously()
                if (movieList is Success<*>)
                    loadData(movieList.data.results)
            }
        }// end launch Coroutine

    }// end fun getMovieList()

}