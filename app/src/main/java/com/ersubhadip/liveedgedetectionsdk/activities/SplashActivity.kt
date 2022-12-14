package com.ersubhadip.liveedgedetectionsdk.activities

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.ersubhadip.liveedgedetectionsdk.R
import com.ersubhadip.liveedgedetectionsdk.databinding.ActivitySplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var animationUp: Animation
    private lateinit var animationDown: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animationUp = AnimationUtils.loadAnimation(this, R.anim.anim_down)
        animationDown = AnimationUtils.loadAnimation(this, R.anim.anim_down)

        binding.splashImage.animation = animationDown
        binding.splashText.animation = animationUp

        GlobalScope.launch(Dispatchers.Main) {
            delay(3000L)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}