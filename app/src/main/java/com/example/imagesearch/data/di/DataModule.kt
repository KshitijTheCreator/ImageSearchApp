package com.example.imagesearch.data.di

import com.example.imagesearch.data.network.ApiService
import com.example.imagesearch.data.network.BASE_URL
import com.example.imagesearch.data.repository.ImplementSearchedImage
import com.example.imagesearch.domain.model.ImageModel
import com.example.imagesearch.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideApiService() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideImageRepository(apiService:ApiService): ImageRepository {
        return ImplementSearchedImage(apiService)
    }
}