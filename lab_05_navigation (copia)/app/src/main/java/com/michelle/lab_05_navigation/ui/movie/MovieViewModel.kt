package com.michelle.lab_05_navigation.ui.movie

import android.text.Editable.Factory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.michelle.lab_05_navigation.MovieReviewerApplication
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {
    fun getMovies() = repository.getMovies()
    fun addMovie(movie: MovieModel) = repository.addMovie(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}