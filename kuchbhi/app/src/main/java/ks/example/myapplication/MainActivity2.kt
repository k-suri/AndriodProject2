package ks.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var textString : TextView
    lateinit var textBoolean: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textString = findViewById(R.id.tvString)
        textBoolean = findViewById(R.id.tvBoolean)
        val bundle = intent.extras
        textString.setText(bundle!!.getString("key1",""))
        textBoolean.setText(bundle!!.getBoolean("key2",false).toString())

    }
}