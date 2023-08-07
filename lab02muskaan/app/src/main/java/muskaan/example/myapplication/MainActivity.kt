package muskaan.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val roll1 =1128
    val roll2=728
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.rollno).setText("${roll1} + ${roll2}")

    }

    fun sum(view: View?){
        findViewById<TextView>(R.id.sum).setText("${roll1+roll2}")
    }
}