package ks.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun startAnimations() {
        // Start animations in both fragments
        val topFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? TopFragment
        val bottomFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as? BottomFragment

        topFragment?.startAnimations()
    }

    private fun stopAnimations() {
        // Stop animations in both fragments
        val topFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? TopFragment
        val bottomFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as? BottomFragment

        topFragment?.stopAnimations()
    }

}