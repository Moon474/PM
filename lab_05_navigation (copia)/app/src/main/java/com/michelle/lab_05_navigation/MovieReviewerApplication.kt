package com.michelle.lab_05_navigation
import android.app.Application
import com.michelle.lab_05_navigation.data.movies
import com.michelle.lab_05_navigation.repository.MovieRepository


class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}