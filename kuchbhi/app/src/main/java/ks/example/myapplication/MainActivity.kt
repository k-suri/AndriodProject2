package ks.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnBundle : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onclick(view: View){
        //btnBundle = findViewById(R.id.btnBundle)
        val bundle = Bundle()
        bundle.putString("key1","First Message")
        bundle.putBoolean("key2",true)
        bundle.putFloat("key3",2.5f)
        bundle.putString("key4","Last Message")
        bundle.putChar("key5",'g')

        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}