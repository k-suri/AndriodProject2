package ks.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (private var itemsList: List<FlowerData> , private val listener: SelectInterface) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>(){
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item.name
        holder.itemTextView.setOnClickListener {
            listener.onItemClicked(item)}

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }


}