package com.example.architecture.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.test.R
import com.example.architecture.test.themoviedb.model.Result

class MovieDbAdapter(val movieDbList: List<Result>) : ListAdapter<Result, MovieDbAdapter.ViewHolder>(MovieDiffCallBack()){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val movieTitle: TextView = view.findViewById(R.id.movieDbTitle)
        val itemImage: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.moviedb_row_item, parent, false)
        return ViewHolder(view)
    }
//
//    cambiar icono de Launch - Change the app icon
//
//    cargar la imagen Real usando una libreria


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = movieDbList.get(position).title
        holder.itemImage.setImageResource(R.drawable.image_1)
    }

    class MovieDiffCallBack : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }

}