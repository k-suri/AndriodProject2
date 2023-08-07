package ks.example.khushisurimidterm

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherInterface {

    @GET("{city}%20Quebec?unitGroup=metric&elements=datetime%2Ctempmax%2Ctempmin%2Ctemp%2Cprecipprob%2Cdescription&include=current&key=BNR9A4ND6HNMB3WX2RTE7R63Q&contentType=json")
    suspend fun getWeather(@Path("city") city: String?): Response<Weather>

}