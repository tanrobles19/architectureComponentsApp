package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecture.test.adapter.MovieDbAdapter
import com.example.architecture.test.application.TestApplication
import com.example.architecture.test.databinding.MovieListLayoutBinding
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.viewmodel.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MovieDbListFragment : Fragment() {

    private lateinit var _binding : MovieListLayoutBinding

    private val remoteApi = TestApplication.remoteApi

    private val viewModelJob = Job()

    private lateinit var moviewViewModel: MovieViewModel
    private lateinit var adapter : MovieDbAdapter

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, state: Bundle?): View {
        _binding = MovieListLayoutBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val moviewDao = AppDataBase.getInstance(application).movieDao()
        this.moviewViewModel = MovieViewModel(moviewDao)

        adapter = MovieDbAdapter(this.moviewViewModel)

        _binding.recyclerViewMovieList.adapter = adapter

        this.moviewViewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        getMovieList()

        return _binding.root
    }

    private fun getMovieList() {
        uiScope.launch {
            CoroutineScope(Dispatchers.IO).launch {
                val movieList = remoteApi.getAudioBookInfoSynchronously()
                if (movieList != null) {

                }
            }
        }// end launch Coroutine

    }// end fun getMovieList()

}