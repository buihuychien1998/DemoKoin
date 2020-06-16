package com.example.helloworld

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("books")
    fun getBooks(): Call<List<Book>>
}