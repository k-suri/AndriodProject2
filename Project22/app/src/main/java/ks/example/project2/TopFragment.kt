package ks.example.project2

import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
    private lateinit var stopButton:Button

    private var cloudAnimation: Animation? = null
    private var sunAnimation: Animation? = null
    private var birdsAnimation: Animation? = null
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
        stopButton = view.findViewById(R.id.button)
        stopButton.setOnClickListener { startAnimations() }

        return  view

    }

    fun startAnimations() {
        // Delay before starting the animations in milliseconds
        val delayDuration = 1000L

        Handler(Looper.getMainLooper()).postDelayed({
            // Start cloud animation
            startCloudAnimation()

            // Start sun animation
            startSunAnimation()

            // Start birds animation after a 1-second delay
            Handler(Looper.getMainLooper()).postDelayed({
                startBirdsAnimation()
            }, 1000L)
        }, delayDuration)
    }

    private fun startCloudAnimation() {
        // Animation duration in milliseconds
        val animationDuration = 3000L

        cloudAnimation = createTranslateAnimation(cloudImageView)
        cloudAnimation?.duration = animationDuration
        cloudAnimation?.repeatCount = Animation.INFINITE
        cloudImageView.startAnimation(cloudAnimation)
    }

    private fun startSunAnimation() {
        // Animation duration in milliseconds
        val animationDuration = 3000L

        sunAnimation = createTranslateAnimation(sunImageView)
        sunAnimation?.duration = animationDuration
        sunAnimation?.repeatCount = Animation.INFINITE
        sunImageView.startAnimation(sunAnimation)
    }

    private fun startBirdsAnimation() {
        // Animation duration in milliseconds
        val animationDuration = 3000L

        birdsAnimation = createTranslateAnimation(birdsImageView)
        birdsAnimation?.duration = animationDuration
        birdsAnimation?.repeatCount = Animation.INFINITE
        birdsImageView.startAnimation(birdsAnimation)
    }

    fun stopAnimations() {
        cloudAnimation?.cancel()
        sunAnimation?.cancel()
        birdsAnimation?.cancel()
    }

    private fun createTranslateAnimation(view: View): TranslateAnimation {
        val fromX = -view.width.toFloat()
        val toX = containerWidth.toFloat()

        val initialAnimation = TranslateAnimation(fromX, toX, 0f, 0f)

        initialAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                // Start the reverse animation
                view.startAnimation(createReverseTranslateAnimation(view))
            }
        })

        return initialAnimation
    }

    private fun createReverseTranslateAnimation(view: View): TranslateAnimation {
        val fromX = containerWidth.toFloat()
        val toX = -view.width.toFloat()

        return TranslateAnimation(fromX, toX, 0f, 0f)
    }

    private val containerWidth: Int
        get() = (activity as? AppCompatActivity)?.findViewById<View>(R.id.frameLayout1)?.width ?: 0

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