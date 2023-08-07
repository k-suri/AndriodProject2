package ks.example.project2

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopFragment : Fragment() {
    private lateinit var cloudImageView: ImageView
    private lateinit var sunImageView: ImageView
    private lateinit var birdsImageView: ImageView
    private lateinit var startButton : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_top, container, false)

        cloudImageView = view.findViewById(R.id.imageView)
        sunImageView = view.findViewById(R.id.imageView2)
        birdsImageView = view.findViewById(R.id.imageView3)
        startButton = view.findViewById(R.id.button3)

        startButton.setOnClickListener { startAnimations() }


        return  view

    }
    fun startAnimations() {
        // Animation duration in milliseconds
        val animationDuration = 3000L

        // Cloud animation
        val cloudAnimation = TranslateAnimation(-cloudImageView.width.toFloat(), containerWidth.toFloat(), 0f, 0f)
        cloudAnimation.duration = animationDuration
        cloudAnimation.repeatCount = Animation.INFINITE
        cloudImageView.startAnimation(cloudAnimation)

        // Sun animation
        val sunAnimation = TranslateAnimation(-sunImageView.width.toFloat(), containerWidth.toFloat(), 0f, 0f)
        sunAnimation.duration = animationDuration
        sunAnimation.repeatCount = Animation.INFINITE
        sunImageView.startAnimation(sunAnimation)
    }

    private val containerWidth: Int
        get() = (activity as? AppCompatActivity)?.findViewById<View>(R.id.frameLayout1)?.width ?: 0

    fun stopAnimations() {

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}