package com.example.travellingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)

        val user:TextView=findViewById(R.id.editText2)
        val submit:Button=findViewById(R.id.button)

        submit.setOnClickListener {
            val intent = Intent(this, MainPage::class.java)
            val usernma = user.text.toString()
            intent.putExtra("user", usernma)
            startActivity(intent)
            Toast.makeText(this,"Successfully Log-in ",Toast.LENGTH_SHORT).show()

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}