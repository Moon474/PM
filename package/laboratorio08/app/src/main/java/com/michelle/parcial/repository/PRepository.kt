package com.michelle.parcial.repository

import com.michelle.parcial.data.models.PackageModel

class PRepository(private val movies: MutableList<PackageModel>) {
    fun getPackages() = movies
    fun addPackages(newPackage: PackageModel) = movies.add(newPackage)



}