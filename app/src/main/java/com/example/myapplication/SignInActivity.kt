package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnReg: Button

    private lateinit var databaseHelper: DBTolong

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        databaseHelper = DBTolong(this)

        etUsername = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword)
        btnLogin = findViewById(R.id.button4)
        btnReg = findViewById(R.id.button3)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (databaseHelper.loginUser(username, password)) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this,MainMenuActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }
        btnReg.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }


    }


}


