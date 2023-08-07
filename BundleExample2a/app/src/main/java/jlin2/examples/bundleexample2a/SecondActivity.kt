package jlin2.examples.bundleexample2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var textString:TextView
    lateinit var textBoolean:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textString = findViewById(R.id.tvString)
        textBoolean = findViewById(R.id.tvBoolean)
        val bundle = intent.extras
        textString.setText(bundle!!.getString("key1", " "))
        textBoolean.setText("Is this true? ${bundle!!.getBoolean("key2", false)}")
    }
}