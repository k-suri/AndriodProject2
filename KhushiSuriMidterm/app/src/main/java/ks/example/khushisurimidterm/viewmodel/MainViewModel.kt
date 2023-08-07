package ks.example.khushisurimidterm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ks.example.khushisurimidterm.Weather
import ks.example.khushisurimidterm.WeatherInterface

class MainViewModel : ViewModel() {
    private val weatherLiveData = MutableLiveData<Weather?>()

    val weatherLiveDate: LiveData<Weather?> get() = weatherLiveData
    lateinit var weatherResponse : retrofit2.Response<Weather>

    suspend fun fetchDataUsingLiveData(weatherInterface: WeatherInterface, city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            //making api call
            //weatherResponse = weatherInterface.getLondonData()

            Log.i("City", city)
            weatherResponse = weatherInterface.getWeather(city)
            val weatherData= weatherResponse.body()
            weatherLiveData.postValue(weatherData)
        }
    }
}