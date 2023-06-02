package com.example.laboratorio05.ui.actor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.repositories.ActorRepository
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import kotlinx.coroutines.launch

class ActorViewModel(private val repository: ActorRepository) : ViewModel() {
    var name = MutableLiveData("")
    var status = MutableLiveData("")

    var id = MutableLiveData(0)


    // TODO: complete getAllActors function
    suspend fun getAllActors() = repository.getActors()

    private fun AddActor(actor: ActorModel){
viewModelScope.launch{
    repository.addActors(actor)
}
    }

    // TODO: Implement functions to validate data and save actors in the DB

    private fun addMovies(actor: ActorModel) {
        viewModelScope.launch {
            // TODO: save movie in the database
            repository.addActors(actor)
        }
    }


    fun createActor() {

        if (!validateData()) {
            status.value = MovieViewModel.WRONG_INFORMATION
            return
        }

        val movie = ActorModel(
            // TODO: This value must not be set here!
            name = name.value!!

        )

        addMovies(movie)
        clearData()

        status.value = MovieViewModel.MOVIE_CREATED
    }

    fun clearStatus() {
        status.value = INACTIVE
    }
    private fun validateData():Boolean{
        when{
            name.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        id.value = 0
        name.value = ""

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}