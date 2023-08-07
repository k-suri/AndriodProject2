package jlin2.examples.recyclerviewexample3b

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "RecyclerView - Example 3b"

        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        dataProvider()
    }
    private fun dataProvider(){
        itemsList.add("January")
        itemsList.add("February")
        itemsList.add("March")
        itemsList.add("April")
        itemsList.add("May")
        itemsList.add("June")
        itemsList.add("July")
        itemsList.add("August")
        itemsList.add("September")
        itemsList.add("October")
        itemsList.add("November")
        itemsList.add("December")
        customAdapter.notifyDataSetChanged()
    }
}