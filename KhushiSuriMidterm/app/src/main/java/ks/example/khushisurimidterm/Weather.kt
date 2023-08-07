package ks.example.khushisurimidterm

data class Weather(
    val address: String,
    val currentConditions: CurrentConditions,
    val days: List<Day>,
    val latitude: Double,
    val longitude: Double,
    val queryCost: Int,
    val resolvedAddress: String,
    val timezone: String,
    val tzoffset: Int
)