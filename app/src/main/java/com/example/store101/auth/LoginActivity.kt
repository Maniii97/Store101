package com.example.store101.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.store101.R

class LoginActivity : AppCompatActivity() {

    private lateinit var etPhone : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : AppCompatButton
    private lateinit var btnGoogle : AppCompatButton
    private lateinit var btnApple : AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnGoogle = findViewById(R.id.btnGoogle)
        btnApple = findViewById(R.id.btnApple)

        btnGoogle.setOnClickListener {
            onGoogleLogin()
        }
        btnApple.setOnClickListener {
            onAppleLogin()
        }

    }

    private fun onGoogleLogin(){
        TODO("Google login using firebase")
    }
    private fun onAppleLogin(){
        TODO("Apple login using firebase")
    }
}