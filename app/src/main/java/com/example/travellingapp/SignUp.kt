package com.example.travellingapp

import android.content.Intent
import android.util.Patterns
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val user: TextView = findViewById(R.id.username)
        val submit: Button = findViewById(R.id.button2)
        val check:CheckBox=findViewById(R.id.checkBox)
        submit.setOnClickListener {
            // Create an intent to navigate to HomePage
            if (check.isChecked()) {
                val intent = Intent(this, MainPage::class.java)
                val userName = user.text.toString()
                intent.putExtra("user", userName) // Pass user name+

                // Collect additional user data
                val id: TextView = findViewById(R.id.name)
                intent.putExtra("data_name", userName)
                intent.putExtra("data_email", id.text.toString())

                val address: TextView = findViewById(R.id.password)
                intent.putExtra("data_address", address.text.toString())

                val num: TextView = findViewById(R.id.phone_no)
                intent.putExtra("data_number", num.text.toString())

                val radiogroup: RadioGroup = findViewById(R.id.radioGroup)
                val checkedGen = radiogroup.checkedRadioButtonId
                if (checkedGen != -1) {
                    val gen = findViewById<RadioButton>(checkedGen)
                    intent.putExtra("data_gender", gen.text.toString())
                }

                startActivity(intent) // Navigate to HomePage
                Toast.makeText(this, "Successfully Signed-Up", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Accept terms and conditions",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
