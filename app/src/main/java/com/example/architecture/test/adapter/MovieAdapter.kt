package com.example.architecture.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.test.R
import com.example.architecture.test.persistence.entity.Movie
import com.example.architecture.test.viewmodel.MovieViewModel

class MovieAdapter(val movieViewModel: MovieViewModel) : ListAdapter<Movie, MovieAdapter.ViewHolder>(SleepNightDiffCallback()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView = view.findViewById(R.id.movieNameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.textView.text = movieViewModel.movieList.value?.get(position)?.name ?: "No name"
    }

    class SleepNightDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldBible: Movie, newBible: Movie): Boolean {
            return oldBible.id == newBible.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }

}