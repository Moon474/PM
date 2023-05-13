package com.michelle.lab_05_navigation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.michelle.lab_05_navigation.R
import com.michelle.lab_05_navigation.databinding.FragmentAddmovieBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Movie_details.newInstance] factory method to
 * create an instance of this fragment.
 */
class Movie_details : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    private lateinit var binding: FragmentAddmovieBinding





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentAddmovieBinding.inflate(inflater, container, false)
        return binding.root
    }

}