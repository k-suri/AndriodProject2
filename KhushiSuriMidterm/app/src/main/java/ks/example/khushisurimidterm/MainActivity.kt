package ks.example.khushisurimidterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ks.example.khushisurimidterm.databinding.ActivityMainBinding
import ks.example.khushisurimidterm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var city:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        city = binding.editTextCity.editableText.toString()
        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        val weatherInterface = RetrofitProvider.retrofitInstance.create(WeatherInterface::class.java)
        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                vm.fetchDataUsingLiveData(weatherInterface,binding.editTextCity.editableText.toString())
            }
        }

        vm.weatherLiveDate.observe(this) { weather ->
            if (weather != null) {
                binding.tvLocation.setText("${weather.resolvedAddress} on ${weather.days[0].datetime.toString()}")
                binding.tvCurrent.setText("Current Tempertaure: ${weather.days[0].temp.toString()}")
                binding.tvMax.setText("Today's Maximum Temperature: ${weather.days[0].tempmax.toString()}")
                binding.tvMin.setText("Today's Minimum Temperature: ${weather.days[0].tempmin.toString()}")
                binding.tvPrecip.setText("Probability of Precipitation${weather.days[0].precipprob.toString()}")
                binding.tvDescrip.setText("TodaysDescription${weather.days[0].description}")
            }
        }
    }
}