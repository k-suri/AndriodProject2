package ks.example.project1_sem3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ks.example.project1_sem3.databinding.ActivityDetailsBinding
import ks.example.project1_sem3.viewmodel.MainViewModel

class DetailsActivity: AppCompatActivity() {
    private val itemsList = ArrayList<Result>()
    lateinit var binding:ActivityDetailsBinding
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val type = bundle?.getString("type")
        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = customAdapter
        val storiesInterface = RetrofitProvider.retrofitInstance.create(StoriesInterface::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            when(type) {
                "arts" -> vm.fetchDataUsingLiveData(storiesInterface,Types.arts)
                "automobiles" -> vm.fetchDataUsingLiveData(storiesInterface,Types.automobiles)
                "booksreview" -> vm.fetchDataUsingLiveData(storiesInterface,Types.technology)
                "business" -> vm.fetchDataUsingLiveData(storiesInterface,Types.business)
                "fashion" -> vm.fetchDataUsingLiveData(storiesInterface,Types.fashion)
                "food" -> vm.fetchDataUsingLiveData(storiesInterface,Types.food)
                "health" -> vm.fetchDataUsingLiveData(storiesInterface,Types.health)
                "politics" -> vm.fetchDataUsingLiveData(storiesInterface,Types.politics)
                "sports" -> vm.fetchDataUsingLiveData(storiesInterface,Types.sports)
            }
        }
        vm.storiesLiveDate.observe(this) { stories ->
            Log.i("Stories", stories.toString())
            if (stories != null) {
                binding.recyclerView.adapter = CustomAdapter(stories.results as ArrayList<Result>)
            }
        }
    }
}