package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.MovieModel

class ActorRepository(private val actorsDao: ActorDao) {
        // TODO: complete Actor ActorRepository

    //s getAllActors e insertActor

    suspend fun getActors() = actorsDao.getAllActors()

    suspend fun addActors(actor: ActorModel) = actorsDao.insertActor(actor)


}