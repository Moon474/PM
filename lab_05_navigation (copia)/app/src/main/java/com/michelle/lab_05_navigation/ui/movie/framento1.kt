package com.michelle.lab_05_navigation.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.data.models.movies

import com.michelle.lab_05_navigation.R

/**
 * A simple [Fragment] subclass.
 * Use the [framento1.newInstance] factory method to
 * create an instance of this fragment.
 */
class framento1 : Fragment() {

    private lateinit var enviarButton: Button
    private lateinit var movieName: TextInputEditText
    private lateinit var movieCategory: TextInputEditText
    private lateinit var movieDescription: TextInputEditText
    private lateinit var movieQualification: TextInputEditText




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_addmovie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind()
        enviarButton.setOnClickListener{
            val movieName = movieName.text.toString()
            val movieCategory = movieCategory.text.toString()
            val movieDescription = movieDescription.text.toString()
            val movieQualification = movieQualification.text.toString()

            val newMovie = MovieModel(movieName, movieCategory, movieDescription, movieQualification)
            val movieTest = MovieModel("Titanic", "Drama", "Romance entre dos pasajeros del titanic", "9.8")

            movies.add(newMovie)

            Log.i("New list item", movies.last().toString())
        }
    }

    fun bind() {
        enviarButton = view?.findViewById(R.id.ButtonOne) as Button
        movieName = view?.findViewById(R.id.name_input) as TextInputEditText
        movieCategory = view?.findViewById(R.id.category_input) as TextInputEditText
        movieDescription = view?.findViewById(R.id.description_input) as TextInputEditText
        movieQualification = view?.findViewById(R.id.qualification_input) as TextInputEditText

    }



}