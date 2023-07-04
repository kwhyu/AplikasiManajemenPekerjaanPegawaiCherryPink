package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignMenuActivity : AppCompatActivity() {
    private lateinit var btnsignup: Button
    private lateinit var btnsign: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_menu)

        btnsignup = findViewById(R.id.buttonsignup)
        btnsign = findViewById(R.id.buttonsign)

        btnsignup.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        btnsign.setOnClickListener{
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
        }
    }
}