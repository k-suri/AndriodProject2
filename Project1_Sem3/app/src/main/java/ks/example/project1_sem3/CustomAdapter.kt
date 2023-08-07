package ks.example.project1_sem3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private var itemsList: ArrayList<Result>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var titleTextView: TextView = view.findViewById(R.id.titleFeild)
        var urlTextView: TextView = view.findViewById(R.id.urlFeild)
        var bylineTextView: TextView = view.findViewById(R.id.bylineFelid)
        var dateTextView: TextView = view.findViewById(R.id.dateFeild)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        if (item != null) {
            holder.titleTextView.text = item.title
            holder.urlTextView.text = item.url
            holder.bylineTextView.text = item.byline
            holder.dateTextView.text = item.published_date.toString()
        }
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}