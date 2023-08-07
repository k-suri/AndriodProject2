package ks.example.myapplication

import retrofit2.Response
import retrofit2.http.GET

interface AlbumsInterface {
    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>
}