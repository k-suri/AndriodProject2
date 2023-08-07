package ks.example.lab2_1129100

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import ks.example.lab2_1129100.model.MovieDetails

class CustomAdapter(private var itemsList: ArrayList<MovieDetails>, mainActivity: MainActivity): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var movieNameTextView: TextView = view.findViewById(R.id.movieName)
        var movieGenreTextView: TextView = view.findViewById(R.id.movieGenre)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.movieNameTextView.text = item.title
        holder.movieGenreTextView.text = item.genre

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}