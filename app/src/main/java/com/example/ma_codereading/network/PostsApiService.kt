package com.example.ma_codereading.network

import com.example.ma_codereading.data.Post
import retrofit2.http.GET

interface PostsApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}