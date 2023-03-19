package com.example.imagesearch.domain.di

import com.example.imagesearch.domain.repository.ImageRepository
import com.example.imagesearch.domain.use_case.GetSearchImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class DomainModule {
    @Provides
    fun provideGetSearchUseCase(imageRepository: ImageRepository) : GetSearchImageUseCase{
        return GetSearchImageUseCase(imageRepository)
    }
}