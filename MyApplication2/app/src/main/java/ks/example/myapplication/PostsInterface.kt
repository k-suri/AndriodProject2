package ks.example.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface PostsInterface {
    @GET("/posts")
    suspend fun getPosts(): Response<Albums>
}