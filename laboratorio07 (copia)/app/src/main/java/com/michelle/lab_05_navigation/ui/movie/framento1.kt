package com.michelle.lab_05_navigation.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.data.models.movies

import com.michelle.lab_05_navigation.R
import com.michelle.lab_05_navigation.databinding.FragmentAddmovieBinding

/**
 * A simple [Fragment] subclass.
 * Use the [framento1.newInstance] factory method to
 * create an instance of this fragment.
 */
class framento1 : Fragment() {


private lateinit var binding: FragmentAddmovieBinding


private val movieViewModel: MovieViewModel by activityViewModels{
MovieViewModel.Factory
}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding= FragmentAddmovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }
private fun setViewModel(){
    binding.viewmodel= movieViewModel
}




    private fun observeStatus() {
        movieViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MovieViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    movieViewModel.clearStatus()
                }

                status.equals(MovieViewModel.MOVIE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, movieViewModel.getMovies().toString())
                    movieViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG="APP TAG"
    }

}



