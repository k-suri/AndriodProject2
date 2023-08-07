package ks.example.fibonacci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ActivityB : AppCompatActivity() {

    val b = Bundle()
    var data1Clicked = false
    var data2Clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        val bundle = intent.extras

        findViewById<TextView>(R.id.data1B).setText(bundle!!.getInt("data1",0).toString())
        findViewById<TextView>(R.id.data2B).setText(bundle!!.getInt("data2",0).toString())
        findViewById<TextView>(R.id.sum_b).setText("${bundle!!.getInt("data1")  + bundle!!.getInt("data2")}")
    }

    fun onGetData1BHandler(view : View?){
        val bundle = intent.extras
        b.putInt("data1B",bundle!!.getInt("data2"))
        data1Clicked = true

        if(data1Clicked && data2Clicked){
            showToast()
        }
    }

    fun onGetData2BHandler(view : View?){
        val bundle = intent.extras
        b.putInt("data2B",bundle!!.getInt("data1")  + bundle!!.getInt("data2") )
        data2Clicked = true
        if(data1Clicked && data2Clicked){
            showToast()
        }
    }

    fun showToast(){
        val text: String = "Data obtained!"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text,
            duration)
        toast.show()
    }

    fun goToActivityAHandler(view: View?){
        val i = Intent(this, ActivityA::class.java)
        i.putExtras(b)
        startActivity(i)
    }
}