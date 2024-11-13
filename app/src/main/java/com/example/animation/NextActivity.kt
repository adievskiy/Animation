package com.example.animation

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NextActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var nameET: EditText
    private lateinit var passET: EditText
    private lateinit var endBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        titleTV = findViewById(R.id.titleTV)
        nameET = findViewById(R.id.nameET)
        passET = findViewById(R.id.passET)
        endBTN = findViewById(R.id.endBTN)

        val titleAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.move_down)
        titleTV.startAnimation(titleAnimation)

        val textAnimation = AnimationUtils.loadAnimation(applicationContext, R.anim.move_up)
        nameET.startAnimation(textAnimation)
        passET.startAnimation(textAnimation)
        endBTN.startAnimation(textAnimation)

        endBTN.setOnClickListener {
            startActivity(Intent(this, EndActivity::class.java))
        }
    }
}