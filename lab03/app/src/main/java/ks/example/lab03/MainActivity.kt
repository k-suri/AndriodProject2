package ks.example.lab03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var hoursTextView: TextView
    private lateinit var minutesTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hoursTextView = findViewById(R.id.hoursFeild)
        minutesTextView = findViewById(R.id.minutesFeild)
    }

    private fun showToast(text:String) {
        val text = text
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext,text,duration)
        toast.show()
    }
    fun onEnterClick(view: View){
        var hours = hoursTextView.text.toString()
        var minutes = minutesTextView.text.toString()
        if(hours == "" || minutes == ""){
            showToast("Hours and minutes values cannot be empty")
            return
        }

        val bundle = Bundle()
        bundle.putInt("hours",hours.toInt())
        bundle.putInt("minutes",minutes.toInt())
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }
}