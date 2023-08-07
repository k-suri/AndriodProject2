package ks.example.lab03

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat

class SecondActivity : AppCompatActivity() {
    private val CHANNEL_ID = "channel_02"
    private val NOTIFICATION_ID = 1
    var hour = 0;
    var minutes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        createNotificationChannel()

        val bundle = intent.extras

        hour = bundle!!.getInt("hours",0)
        minutes = bundle!!.getInt("minutes",0)

    }


    private fun createNotificationChannel() {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_desc)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
    }

    private fun sendNotification(view: View?) {

        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm Clock")
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, PendingIntent.FLAG_IMMUTABLE)

        builder.setSmallIcon(R.drawable.alarm)
        builder.setContentIntent(pendingIntent)
        builder.setAutoCancel(true)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.alarm))
        builder.setContentTitle(" Please complete lab 3")
        builder.setContentText("Lab 3 will be due on March 24")

        val notificationManager = getSystemService(
            NOTIFICATION_SERVICE
        ) as NotificationManager
        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }


    private fun showToast() {
        val text = "Notification is sent"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext,text,duration)
        toast.show()
    }


    fun sendNotificationClick(view: View){
        showToast()
        sendNotification(view)
    }
}