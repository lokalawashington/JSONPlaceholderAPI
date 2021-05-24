package com.kanyideveloper.jsonplaceholderapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    fun getPhotos() : Call<JsonPlaceholder>

}

object PhotosApi{
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
