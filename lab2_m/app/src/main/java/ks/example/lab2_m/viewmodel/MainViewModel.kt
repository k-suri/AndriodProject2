package ks.example.lab2_m.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ks.example.lab2_m.model.Movie

class MainViewModel:ViewModel() {
    private val _movies = MutableLiveData<ArrayList<Movie>>()
    val movies: LiveData<ArrayList<Movie>> get() = _movies

    fun addMovie(movie: Movie) {
        val currentMovies = _movies.value?: ArrayList()
        currentMovies.add(movie)
        _movies.value = currentMovies
    }
}