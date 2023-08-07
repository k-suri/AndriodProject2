package ks.example.commonintentdemo

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.provider.AlarmClock
import android.view.Gravity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onButtonClick(view:View){
        when (view.id){
            R.id.btnAlarm -> {
                createAlarm("Info 6124 Alarm", 19, 59)
            }
            R.id.btnTimer -> {
               setTimer("Set Timer",60)
           }
        }
    }
    fun createAlarm(message:String, hour:Int ,minutes:Int){
        val Intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE,message)
            putExtra(AlarmClock.EXTRA_HOUR,hour)
            putExtra(AlarmClock.EXTRA_MINUTES,minutes)
        }

        try {
            startActivity(Intent)
            val toast:Toast = Toast.makeText(applicationContext,"The alarm is set",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL ,0,0)
            toast.show()
        }catch(e: ActivityNotFoundException){

        }

    }

    fun setTimer(message: String,seconds:Int){
        val Intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE,message)
            putExtra(AlarmClock.EXTRA_LENGTH,seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI,true)
        }
        try {
            startActivity(Intent)
            val toast:Toast = Toast.makeText(applicationContext,"TIMER is set",Toast.LENGTH_LONG)
            toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL ,0,0)
            toast.show()
        }catch(e: ActivityNotFoundException){

        }
    }

}