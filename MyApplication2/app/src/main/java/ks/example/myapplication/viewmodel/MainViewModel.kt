package ks.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import ks.example.myapplication.Albums

class MainViewModel {
    private val _albums = MutableLiveData<Albums>()
}