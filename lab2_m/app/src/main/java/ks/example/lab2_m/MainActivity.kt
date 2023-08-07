package ks.example.lab2_m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ks.example.lab2_m.databinding.ActivityMainBinding
import ks.example.lab2_m.model.Movie
import ks.example.lab2_m.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val itemsList = ArrayList<Movie>()
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        movieAdapter = MovieAdapter(itemsList,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = movieAdapter
        binding.saveButton.setOnClickListener{
            val titleText = binding.nameInput
            val genreText = binding.genreInput
            val title = titleText.text.toString()
            val genre = genreText.text.toString()

            if (title.isNotEmpty() && genre.isNotEmpty()) {
                val movie = Movie(title, genre)
                mainViewModel.addMovie(movie)
                titleText.setText("")
                genreText.setText("")
            }
        }
        mainViewModel.movies.observe(this, { movies ->
            binding.recyclerView.adapter = MovieAdapter(movies,this)
        })
    }
}