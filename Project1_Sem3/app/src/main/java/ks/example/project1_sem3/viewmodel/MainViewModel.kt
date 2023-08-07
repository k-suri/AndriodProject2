package ks.example.project1_sem3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ks.example.project1_sem3.Stories
import ks.example.project1_sem3.StoriesInterface
import ks.example.project1_sem3.Story
import ks.example.project1_sem3.Types

class MainViewModel:ViewModel() {
    private val storiesLiveData = MutableLiveData<Story?>()

    val storiesLiveDate: LiveData<Story?> get() = storiesLiveData
    lateinit var storiesResponse : retrofit2.Response<Story>

    suspend fun fetchDataUsingLiveData(storiesInterface: StoriesInterface,type:Types) {
        CoroutineScope(Dispatchers.IO).launch {
            //making api call
            storiesResponse = when(type) {
                Types.arts -> storiesInterface.getArtStories()
                Types.automobiles -> storiesInterface.getAutomobileStories()
                Types.technology -> storiesInterface.getTechnologyStories()
                Types.business -> storiesInterface.getBusinessStories()
                Types.fashion -> storiesInterface.getFashionStories()
                Types.food -> storiesInterface.getFoodStories()
                Types.health -> storiesInterface.getHealthStories()
                Types.politics -> storiesInterface.getPoliticsStories()
                Types.sports -> storiesInterface.getSportsStories()
            }
            val storiesData = storiesResponse.body()
            storiesLiveData.postValue(storiesData)
        }
    }
}

