package com.example.architecture.test.navigation.destination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.architecture.test.application.TestApplication
import com.example.architecture.test.databinding.FragmentMainBinding
import com.example.architecture.test.persistence.AppDataBase
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentMainBinding

    private val remoteApi = TestApplication.remoteApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = _binding.root

        val addMovie = _binding.addNewMovieButton

        addMovie.setOnClickListener {
//            destinationCreateNewMovie()
            val result = remoteApi.getAudioBookInfoSynchronously()
        }

        return view
    }

    fun destinationCreateNewMovie() {
        val direction = HomeFragmentDirections.actionHomefragmentToCreateNewMovie()
        this.view?.findNavController()?.navigate(direction)
    }// end fun destinationCreateNewMovie()

}