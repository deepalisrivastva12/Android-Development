package com.example.travellingapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val button: Button =findViewById(R.id.edit_profile)
        button.setOnClickListener{
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }
        val user_name:TextView=findViewById(R.id.user_name)
        val email:TextView=findViewById(R.id.user_id)
        val gender:TextView=findViewById(R.id.gender)
        val address:TextView=findViewById(R.id.add)
        val number:TextView=findViewById(R.id.phone_no)


        val data1=intent.getStringExtra("data_name")
        val data2=intent.getStringExtra("data_email")
        val data3=intent.getStringExtra("data_gender")
        val data4=intent.getStringExtra("data_number")
        val data5=intent.getStringExtra("data_address")


        user_name.text=data1
        email.text=data2
        gender.text=data3
        number.text=data4
        address.text=data5


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}