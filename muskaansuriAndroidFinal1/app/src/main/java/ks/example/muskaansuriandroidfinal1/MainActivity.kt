package ks.example.muskaansuriandroidfinal1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDisplayMapClick (view : View?) {
        val bundle = Bundle()
        bundle.putString("address","1129")
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtras(bundle)
        showToast()
        startActivity(intent)
    }

    fun showToast(){
        val text: String = "Showing Map"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text,
            duration)
        toast.show()
    }
}