package com.example.imagesearch.data.repository

import com.example.imagesearch.common.toDomainModel
import com.example.imagesearch.data.network.ApiService
import com.example.imagesearch.data.network.KEY
import com.example.imagesearch.domain.model.ImageModel
import com.example.imagesearch.domain.repository.ImageRepository

class ImplementSearchedImage(private val apiService: ApiService): ImageRepository {
    override suspend fun getSearchedImage(query: String): List<ImageModel> {
        try{
            return apiService.getSearchImage(key = KEY, query = query).hits.map { it.toDomainModel()}
        }
        catch(e : java.lang.Exception){
            throw Exception(e)
        }
    }
}