package com.example.architecture.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.test.databinding.MoviedbRowItemBinding
import com.example.architecture.test.themoviedb.model.Result
import com.squareup.picasso.Picasso

class MovieDbAdapter(val movieDbList: List<Result>, val movieListener: MovieListener) : ListAdapter<Result, MovieDbAdapter.ViewHolder>(MovieDiffCallBack()){

    class ViewHolder private constructor(val binding: MoviedbRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Result, movieListener: MovieListener) {
            binding.movieClickListener = movieListener
            binding.movie = item
            Picasso.get().load("https://image.tmdb.org/t/p/w500" + item.backdrop_path).into(binding.itemImage)
        }

        companion object{
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MoviedbRowItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }// end constructor()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result =  movieDbList.get(position)
        holder.bind(result, movieListener)
    }

    class MovieDiffCallBack : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

    class MovieListener(val clickListener: (sleepId: Long) -> Unit) {
        fun onClick(night: Result) = clickListener(night.id)
    }

}