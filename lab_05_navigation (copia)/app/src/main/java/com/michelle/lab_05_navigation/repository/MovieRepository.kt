package com.michelle.lab_05_navigation.repository

import com.michelle.lab_05_navigation.data.models.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies() = movies
    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)



}