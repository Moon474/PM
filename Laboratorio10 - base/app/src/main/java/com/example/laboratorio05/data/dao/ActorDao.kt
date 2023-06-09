package com.example.laboratorio05.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.data.model.MovieWithActor
@Dao

interface ActorDao {
    // TODO: create getAllActors method
    // TODO: create insertActor method

    @Query("SELECT * FROM actor_table")
    suspend fun getAllActors(): List<ActorModel>

    @Transaction
    @Insert
    suspend fun insertActor(actor: ActorModel)

    //@Query("SELECT * FROM movie_table WHERE movieId = :movieId")

    //suspend fun getMovieWithActorsById(movieId: Int): MovieWithActor
}