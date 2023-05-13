package com.michelle.lab_05_navigation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.michelle.lab_05_navigation.databinding.FragmentAddmovieBinding
import com.michelle.lab_05_navigation.databinding.FragmentMovieDetailsBinding
import com.michelle.lab_05_navigation.ui.movie.viewmodel.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieDetailsBinding





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = movieViewModel
    }
}