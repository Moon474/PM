package com.michelle.parcial.ui.packages.HOME.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.michelle.parcial.data.models.PackageModel
import com.michelle.parcial.databinding.MovieItemBinding


class PackageRecyclerViewHolder(private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: PackageModel, clickListener: (PackageModel) -> Unit) {
        binding.titleTextView.text = movie.name

        binding.movieItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}

