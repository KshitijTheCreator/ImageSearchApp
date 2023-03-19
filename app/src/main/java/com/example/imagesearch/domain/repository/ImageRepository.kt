package com.example.imagesearch.domain.repository

import com.example.imagesearch.domain.model.ImageModel

interface ImageRepository {

    suspend fun getSearchedImage(query:String): List<ImageModel>
}