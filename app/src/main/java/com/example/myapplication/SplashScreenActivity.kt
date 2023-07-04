package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var cherry: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        cherry = findViewById(R.id.cherrykon)
        cherry.alpha=0f
        cherry.animate().setDuration(1500).alpha(1f).withEndAction{
            val i = Intent(this,SignMenuActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}