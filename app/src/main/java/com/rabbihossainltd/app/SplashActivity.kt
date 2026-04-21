package com.rabbihossainltd.app

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logoImage)
        val title = findViewById<TextView>(R.id.logoText)

        val scaleX = ObjectAnimator.ofFloat(logo, "scaleX", 0.75f, 1f)
        val scaleY = ObjectAnimator.ofFloat(logo, "scaleY", 0.75f, 1f)
        val alphaLogo = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f)
        val transLogo = ObjectAnimator.ofFloat(logo, "translationY", 50f, 0f)

        val alphaText = ObjectAnimator.ofFloat(title, "alpha", 0f, 1f)
        val transText = ObjectAnimator.ofFloat(title, "translationY", 30f, 0f)

        AnimatorSet().apply {
            playTogether(scaleX, scaleY, alphaLogo, transLogo, alphaText, transText)
            duration = 1200
            interpolator = AccelerateDecelerateInterpolator()
            start()
        }

        logo.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1800)
    }
}
