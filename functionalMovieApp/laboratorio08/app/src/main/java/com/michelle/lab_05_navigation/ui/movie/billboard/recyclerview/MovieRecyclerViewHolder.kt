package com.michelle.lab_05_navigation.ui.movie.billboard.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.databinding.MovieItemBinding


class MovieRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {
        binding.titleTextView.text = movie.name
        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}

