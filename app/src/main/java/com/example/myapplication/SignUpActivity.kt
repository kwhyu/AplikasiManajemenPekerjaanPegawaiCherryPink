package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnRegister: Button

    private lateinit var databaseHelper: DBTolong

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        databaseHelper = DBTolong(this)

        etUsername = findViewById(R.id.editTextTextEmailAddress)
        etPassword = findViewById(R.id.editTextTextPassword)
        etConfirmPassword = findViewById(R.id.editTextKonfirmPassword)
        btnRegister = findViewById(R.id.button3)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (password == confirmPassword) {
                    if (databaseHelper.registerUser(username, password)) {
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        // Lakukan navigasi ke halaman login
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter username, password, and confirm password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}