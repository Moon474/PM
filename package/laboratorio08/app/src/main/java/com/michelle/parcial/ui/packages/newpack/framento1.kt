package com.michelle.parcial.ui.packages.newpack

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.michelle.parcial.databinding.FragmentAddmovieBindingImpl

import com.michelle.parcial.ui.packages.viewmodel.PackageViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [framento1.newInstance] factory method to
 * create an instance of this fragment.
 */
class framento1 : Fragment() {

    private lateinit var binding: FragmentAddBinding


    private val PackageViewModel: PackageViewModel by activityViewModels{
        PackageViewModel.Factory
    }


    //?





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding= FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }
private fun setViewModel(){
    binding.viewmodel= PackageViewModel
}




    private fun observeStatus() {
        PackageViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(PackageViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    PackageViewModel.clearStatus()
                }

                status.equals(PackageViewModel.PACKAGE_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, PackageViewModel.getMovies().toString())
                    PackageViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object{
        const val APP_TAG="APP TAG"
    }

}



