package com.michelle.parcial.ui.packages.HOME.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michelle.parcial.data.models.PackageModel
import com.michelle.parcial.data.models.packages
import com.michelle.parcial.databinding.MovieItemBindingImpl


class PackageRecyclerViewAdapter (

    private val clickListener: (PackageModel) -> Unit
        ) : RecyclerView.Adapter<PackageRecyclerViewHolder>(){
            private val movies = ArrayList<PackageModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageRecyclerViewHolder {

        val binding = MovieItemBindingImpl.inflate(LayoutInflater.from(parent.context),parent,false)
        return PackageRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return packages.size
    }

    override fun onBindViewHolder(holder: PackageRecyclerViewHolder, position: Int) {
        val package = packages[position]
        holder.bind(package,clickListener)
    }

    fun setData(PackageList: List<PackageModel>){
        packages.clear()
        packages.addAll(PackageList)
    }
}