package com.michelle.lab_05_navigation.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michelle.lab_05_navigation.R
import com.michelle.lab_05_navigation.data.models.MovieModel
import com.michelle.lab_05_navigation.databinding.FragmentAddmovieBinding
import com.michelle.lab_05_navigation.databinding.FragmentMainBinding
import com.michelle.lab_05_navigation.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.michelle.lab_05_navigation.ui.movie.viewmodel.MovieViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class   Main : Fragment() {



    private lateinit var adapter: MovieRecyclerViewAdapter



    private val mviewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private fun showSelectedItem(movie: MovieModel){
        mviewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.atobe)
    }

    //here idk
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


    private fun displayMovies(){
        adapter.setData(mviewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter= MovieRecyclerViewAdapter { selectedMovie->
            showSelectedItem(selectedMovie)

        }

        binding.recyclerView.adapter = adapter
        displayMovies()

    }



}
