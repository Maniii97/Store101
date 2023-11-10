package com.example.store101.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.store101.R

class SignUpActivity : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etEmail : EditText
    private lateinit var etPassword : EditText
    private lateinit var etConfirmPassword : EditText
    private lateinit var etPhone : EditText
    private lateinit var btnSignUp : AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        etPhone = findViewById(R.id.etPhone)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            onSignUpClick()
        }
    }

    private fun authenticatePassword() : Boolean {
        val password = etPassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()
        if(password != confirmPassword){
            etConfirmPassword.error = "Password does not match"
            return false
        }
        return true
    }

    private fun onSignUpClick() {
        authenticatePassword()
    }
}