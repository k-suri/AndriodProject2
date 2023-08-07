package ks.example.fibonacci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ActivityA : AppCompatActivity() {

    val bundle = Bundle()
    val initDataVal = 0
    val data1Val = 1
    lateinit var text1 : TextView
    lateinit var text2 : TextView
    var data1Clicked = false
    var data2Clicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        text1 = findViewById<TextView>(R.id.data1A)
        text2 = findViewById<TextView>(R.id.data2A)
        findViewById<TextView>(R.id.initVal).setText(initDataVal.toString())
        text1.setText(data1Val.toString())
        text2.setText("${initDataVal + data1Val}")


        val bundle = intent.extras
        val dataFromB1 = bundle?.getInt("data1B") ?: 0
        val dataFromB2 = bundle?.getInt("data2B") ?: 0
        if(dataFromB1 != 0 && dataFromB2 != 0){
            findViewById<TextView>(R.id.initVal).setText(dataFromB1.toString())
            text1.setText(dataFromB2.toString());
            text2.setText("${dataFromB1!! + dataFromB2!!}")
        }
    }

    fun onGetData1Handler(view : View?){
        bundle.putInt("data1",text1.text.toString().toInt())
        data1Clicked = true

        if(data1Clicked && data2Clicked){
            showToast()
        }
    }

    fun onGetData2Handler(view : View?){
        bundle.putInt("data2",text2.text.toString().toInt())
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

    fun goToActivityBHandler(view: View?){
        val intent = Intent(this, ActivityB::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}