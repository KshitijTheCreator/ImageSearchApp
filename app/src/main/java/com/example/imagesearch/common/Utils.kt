package com.example.imagesearch.common

import com.example.imagesearch.data.model.HitDTO
import com.example.imagesearch.domain.model.ImageModel

fun HitDTO.toDomainModel(): ImageModel {
    return ImageModel(
        imageUrl = this.previewURL
    )
}