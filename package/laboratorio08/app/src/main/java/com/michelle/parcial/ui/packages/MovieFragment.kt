package com.michelle.parcial.ui.packages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.michelle.parcial.databinding.
import com.michelle.parcial.ui.packages.viewmodel.PackageViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {


    private val movieViewModel: PackageViewModel by activityViewModels{
        PackageViewModel.Factory
    }

    private lateinit var binding: FragmentDetailsBinding




    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = movieViewModel
    }
}