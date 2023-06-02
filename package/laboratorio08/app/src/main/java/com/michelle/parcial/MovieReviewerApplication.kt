package com.michelle.parcial
import android.app.Application
import com.michelle.parcial.data.models.packages
import com.michelle.parcial.repository.PRepository


class MovieReviewerApplication: Application() {
    val movieRepository: PRepository by lazy {
        PRepository(packages)
    }
}