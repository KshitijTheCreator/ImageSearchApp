package com.example.imagesearch.presentation

import com.example.imagesearch.domain.model.ImageModel


//Acts as the state holder in our View Model
data class ImageState(
    val isLoading: Boolean= false,
    val data:List<ImageModel>?= null,
    val error:String=""
)