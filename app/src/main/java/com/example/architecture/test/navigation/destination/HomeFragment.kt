package com.example.architecture.test.navigation.destination

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.example.architecture.test.R
import com.example.architecture.test.application.TestApplication
import com.example.architecture.test.databinding.FragmentMainBinding
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding

    private val remoteApi = TestApplication.remoteApi

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        setHasOptionsMenu(true)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = _binding.root

        val addMovie = _binding.addNewMoviesButton
        val movieList = _binding.movieListButton
        val movieListCompose = _binding.movieListButtonForJetPackCompose

        movieList.setOnClickListener {
            destinationToMovieDbListFragment()
        }

        addMovie.setOnClickListener {
            destinationCreateNewMovie()
        }

        movieListCompose.setOnClickListener {
            destinationToMovieListCompose()
        }

        return view
    }

    fun destinationCreateNewMovie() {
        val direction = HomeFragmentDirections.actionHomefragmentToCreateNewMovie()
        this.view?.findNavController()?.navigate(direction)
    }// end fun destinationCreateNewMovie()

    fun destinationToMovieDbListFragment() {
        val direction = HomeFragmentDirections.actionHomeFragmentToMovieDbListFragment()
        this.view?.findNavController()?.navigate(direction)
    }

    fun destinationToMovieListCompose() {
        val destination = HomeFragmentDirections.actionHomeFragmentToMovieListWithCompose()
        this.view?.findNavController()?.navigate(directions = destination)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_movie, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController()) || super.onOptionsItemSelected(item)
    }

}