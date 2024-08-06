package com.example.utilitytracker.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.utilitytracker.R
import com.example.utilitytracker.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = findViewById(R.id.passwordEditText)
        val loginButton: Button = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            viewModel.login(username, password)
        }

        viewModel.loginResult.observe(this, { result ->
            if (result != null) {
                // Manejar el inicio de sesión exitoso
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // Manejar el error
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
