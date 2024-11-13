package com.example.animation

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var imageViewIV: ImageView
    private lateinit var buttonBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageViewIV = findViewById(R.id.imageViewIV)
        buttonBTN = findViewById(R.id.buttonBTN)

        val animationImage = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        imageViewIV.startAnimation(animationImage)

        val animationButton = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in)
        buttonBTN.startAnimation(animationButton)
        buttonBTN.setOnClickListener {
            startActivity(Intent(this, NextActivity::class.java))
        }
    }
}