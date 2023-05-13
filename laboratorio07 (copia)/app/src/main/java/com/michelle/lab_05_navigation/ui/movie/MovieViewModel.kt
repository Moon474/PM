package com.michelle.lab_05_navigation.ui.movie

import android.text.Editable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.michelle.lab_05_navigation.MovieReviewerApplication
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository): ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")
    fun getMovies() = repository.getMovies()
    fun addMovie(movie: MovieModel) = repository.addMovie(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""

    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() ->
                return false

            category.value.isNullOrEmpty ()->
                return false

            description.value.isNullOrEmpty()->
                return false

            qualification.value.isNullOrEmpty()->
                return false

        }
        return true
    }





    private fun addMovies (movie: MovieModel) = repository.addMovie(movie)
    fun createMovie() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val movie = MovieModel(
        name.value!!,
        category.value!!,
        description.value!!,
        qualification.value!!

        )
        addMovies (movie)
        clearData()
        status.value = MOVIE_CREATED
    }

    private fun clearData() {

        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    fun clearStatus(){
        status.value = INACTIVE
    }
}






