package ks.example.project1_sem3

import retrofit2.Response
import retrofit2.http.GET

interface StoriesInterface {
    @GET("/svc/topstories/v2/arts.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getArtStories(): Response<Story>

    @GET("/svc/topstories/v2/automobiles.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getAutomobileStories(): Response<Story>

    @GET("/svc/topstories/v2/technology.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getTechnologyStories(): Response<Story>

    @GET("/svc/topstories/v2/business.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getBusinessStories(): Response<Story>

    @GET("/svc/topstories/v2/fashion.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getFashionStories(): Response<Story>

    @GET("/svc/topstories/v2/food.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getFoodStories(): Response<Story>

    @GET("/svc/topstories/v2/health.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getHealthStories(): Response<Story>

    @GET("/svc/topstories/v2/politics.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getPoliticsStories(): Response<Story>

    @GET("/svc/topstories/v2/sports.json?api-key=5tDXNEhyenz80GpkxNYxyze5FqwP913A")
    suspend fun getSportsStories(): Response<Story>
}