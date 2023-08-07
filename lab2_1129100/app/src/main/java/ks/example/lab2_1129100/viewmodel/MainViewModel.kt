package ks.example.lab2_1129100.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ks.example.lab2_1129100.model.MovieDetails

class MainViewModel:ViewModel() {
    private val _movies = MutableLiveData<ArrayList<MovieDetails>>()
    val movies: LiveData<ArrayList<MovieDetails>> get() = _movies

    fun addMovie(movie: MovieDetails) {
        val currentMovies = _movies.value?: ArrayList()
        currentMovies.add(movie)
        _movies.value = currentMovies
    }
}