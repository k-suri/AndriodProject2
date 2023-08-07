package khushi.example.lab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val studentId1 = 1129
    val studentId2 = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.studentId).setText("${studentId1} + ${studentId2}")
    }

    fun sum(view: View?){
        findViewById<TextView>(R.id.sumValue).setText("${studentId1+studentId2}")
    }

}