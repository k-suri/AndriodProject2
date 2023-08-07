package ks.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FlowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower)

        val bundle = intent.extras
        findViewById<TextView>(R.id.flowerName).setText("${bundle!!.getString("name","")}")
        findViewById<TextView>(R.id.flowerDesc).setText("${bundle!!.getString("desc","")}")
        findViewById<TextView>(R.id.flowerPrice).setText("${bundle!!.getDouble("price",0.0).toString()}")
    }

}