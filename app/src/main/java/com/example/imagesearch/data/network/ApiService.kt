package com.example.imagesearch.data.network

import com.example.imagesearch.data.model.PixabayDTO
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://pixabay.com/"
const val KEY = "34357072-c3fce7ad313d1cc650acb2522"
interface ApiService {
//    api/?key=&q=yellow+flowers&image_type=photo&pretty=true

    @GET("api/")
    suspend fun getSearchImage(
        @Query("key") key: String,
        @Query("q") query: String
    ) : PixabayDTO
}