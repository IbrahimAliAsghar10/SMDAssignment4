package com.example.smdassignment4.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.smdassignment4.R

class IntroActivity : AppCompatActivity() {
    private var startBtn: ConstraintLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        startBtn = findViewById(R.id.startbtn)
        startBtn!!.setOnClickListener {
            startActivity(
                Intent(
                    this@IntroActivity,
                    MainActivity::class.java
                )
            )
        }
    }
}