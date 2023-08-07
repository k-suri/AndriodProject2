package ks.example.lab2_1129100

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ks.example.lab2_1129100.databinding.ActivityMainBinding
import ks.example.lab2_1129100.model.MovieDetails
import ks.example.lab2_1129100.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val itemsList = ArrayList<MovieDetails>()
    private lateinit var customAdapter: CustomAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        customAdapter = CustomAdapter(itemsList,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = customAdapter
        binding.saveBtn.setOnClickListener{
            val titleText = binding.nameFelid
            val genreText = binding.genreFeild
            val title = titleText.text.toString()
            val genre = genreText.text.toString()

            if (title.isNotEmpty() && genre.isNotEmpty()) {
                val movie = MovieDetails(title, genre)
                mainViewModel.addMovie(movie)
                titleText.setText("")
                genreText.setText("")
            }
        }
        mainViewModel.movies.observe(this, { movies ->
           binding.recyclerView.adapter = CustomAdapter(movies,this)
        })
    }


}
