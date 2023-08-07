package ks.example.myapplication

import com.google.gson.annotations.SerializedName

data class AlbumsItem(
   @SerializedName("body")
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)