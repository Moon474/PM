package com.michelle.parcial.ui.packages.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.michelle.parcial.MovieReviewerApplication
import com.michelle.parcial.data.models.PackageModel
import com.michelle.parcial.repository.PRepository

class PackageViewModel (private val PackageRepository: PRepository): ViewModel() {
    var name = MutableLiveData("")
    var price = MutableLiveData("")



    fun getMovies() = PackageRepository.getPackages()

    private fun addMovies(movie: PackageModel) = PackageRepository.addPackages(movie)

    fun createMovie() {
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val p = PackageModel(
            name.value!!,
            price.value!!

        )

        addMovies(p)
        clearData()
        status.value = PACKAGE_CREATED
    }


    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            price.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData(){
        name.value = ""
        price.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                PackageViewModel(app.movieRepository)
            }
        }
        const val PACKAGE_CREATED = "p created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

    fun setSelectedMovie(pck: PackageModel) {
        name.value = pck.name

    }
}