package com.example.imagesearch.domain.use_case

import com.example.imagesearch.common.ResourceStateManager
import com.example.imagesearch.domain.model.ImageModel
import com.example.imagesearch.domain.repository.ImageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSearchImageUseCase(private val imageRepository: ImageRepository) {
    operator fun invoke(query: String): Flow<ResourceStateManager<List<ImageModel>>> = flow {
        emit(ResourceStateManager.Loading())
        try{
            emit(ResourceStateManager.Success(data = imageRepository.getSearchedImage(query = query)))
        }
        catch(e: java.lang.Exception){
            emit(ResourceStateManager.Error(message = e.message.toString()))
        }
    }
}