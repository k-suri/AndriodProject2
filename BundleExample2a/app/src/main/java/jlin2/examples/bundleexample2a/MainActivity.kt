package jlin2.examples.bundleexample2a

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnBundle: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View?){
        btnBundle = findViewById(R.id.btnBundle)
        val bundle = Bundle()
        bundle.putString("key1", "Hi, this is my first message")
        bundle.putBoolean("key2", true)
        bundle.putFloat("key3", 2.5f)
        bundle.putString("key4", "Hi, This is my second message")
        bundle.putChar("key5", 'a')
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}