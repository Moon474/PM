package com.michelle.parcial.ui.packages.HOME

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.michelle.parcial.R
import com.michelle.parcial.data.models.PackageModel
import com.michelle.parcial.databinding.FragmentMainBinding
import com.michelle.parcial.ui.packages.HOME.recyclerview.PackageRecyclerViewAdapter
import com.michelle.parcial.ui.packages.viewmodel.PackageViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class   Main : Fragment() {


    private val mviewModel: PackageViewModel by activityViewModels {
        PackageViewModel.Factory
    }

    private lateinit var adapter: PackageRecyclerViewAdapter
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.addMovieB.setOnClickListener{
            mviewModel.clearData()
            it.findNavController().navigate(R.id.action_atoAdd)

        }


    }

    private fun showSelectedItem(movie: PackageModel){
        mviewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.atobe)
    }

    //here idk




    private fun displayMovies(){
        adapter.setData(mviewModel.getMovies().asReversed())
        adapter.notifyItemInserted(0)
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter= PackageRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)

        }

        binding.recyclerView.adapter = adapter
        displayMovies()

    }



}
