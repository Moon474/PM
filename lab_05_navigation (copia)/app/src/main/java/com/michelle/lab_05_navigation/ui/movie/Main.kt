package com.michelle.lab_05_navigation.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.michelle.lab_05_navigation.R

/**
 * A simple [Fragment] subclass.
 * Use the [Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class   Main : Fragment() {
    private lateinit var addButton: FloatingActionButton
    private lateinit var titleCard: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        addListeners()
    }

    private fun bind() {
        titleCard = view?.findViewById(R.id.CardView_SW) as CardView
        addButton = view?.findViewById(R.id.add_movie_b) as FloatingActionButton

    }

    private fun addListeners() {

       titleCard.setOnClickListener {
            it.findNavController()
                .navigate(R.id.atobe)
        }
        addButton.setOnClickListener{
            it.findNavController().navigate(R.id.action_atoAdd)
        }
    }

}