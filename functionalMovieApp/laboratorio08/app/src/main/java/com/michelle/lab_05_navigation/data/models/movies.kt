package com.michelle.lab_05_navigation.data.models


val name = "La princesa Mononoke"
val category = "Drama"
val description = "Un príncipe se ve involucrado en un conflicto entre una princesa del bosque y el abuso de la mecanización."
val qualification = "9"

val name2 = "Interestelar"
val category2 = "Ciencia Ficción"
val description2 = "Gracias a un descubrimiento, un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial"
val qualification2 = "9"
val movies = mutableListOf(
    MovieModel(name, category, description, qualification),
    MovieModel(name2, category2, description2, qualification2),
)