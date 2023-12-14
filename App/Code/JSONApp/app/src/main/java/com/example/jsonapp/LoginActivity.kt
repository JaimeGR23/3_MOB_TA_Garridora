package com.example.jsonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("GameLoginSharedPref", MODE_PRIVATE)
        val last_user = sharedPreferences.getString("last_user", null)

        val editTextUsername = findViewById<EditText>(R.id.UserText)
        val editTextPassword = findViewById<EditText>(R.id.PasswordText)
        val buttonLogin = findViewById<Button>(R.id.LoginButton)

        findViewById<TextView>(R.id.UserText).text = last_user

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // login logic
            if ((username == "ruben" && password == "123456*") || (username == "jaime" && password == "jaime123a")) {
                Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MyMainActivityFinal::class.java)
                //Load user for next
                val sharedPreferences = getSharedPreferences("GameLoginSharedPref", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("last_user", username)
                editor.apply()
                // start app
                startActivity(intent)
            } else {
                Toast.makeText(this, "User or password is not correct", Toast.LENGTH_SHORT).show()
            }
        }
    }
}