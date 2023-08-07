package ks.example.android2_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class MainActivity : AppCompatActivity() , ConfirmationFragment.SendMessages {
    lateinit var Msg: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initButton()
        Msg = findViewById(R.id.LevelTextView)
    }

    private fun initButton() {
        val btnShowDialog = findViewById<Button>(R.id.showDialog)
        btnShowDialog.setOnClickListener {
            addLevelsFragment()
        }
        val instructionButton = findViewById<Button>(R.id.instructionButton)
        val intent = Intent(this,MainActivity2::class.java)
        instructionButton.setOnClickListener {
            startActivity(intent)
        }


    }

    private fun addLevelsFragment() {
        val confirmFrag: DialogFragment? = ConfirmationFragment
            .newInstance(R.string.confirm)
        confirmFrag!!.show(supportFragmentManager, "dialog")
    }

    override fun choiceMade(msg: Int?)
    {
        Msg.text = "Happiness Level is: ${ConfirmationFragment.levels[msg!!]}"
        ConfirmationFragment.checkedItem = msg
    }

}