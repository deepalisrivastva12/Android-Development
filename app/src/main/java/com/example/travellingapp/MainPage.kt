package com.example.travellingapp
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import kotlinx.coroutines.selects.select

class MainPage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var username:String?=null
    fun updateUsername(textid:TextView){
        textid.text = "Welcome, ${username ?: "Guest"}!"
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)

        username=intent.getStringExtra("user")
        val textid:TextView=findViewById(R.id.textView2)
        val spinner_opt: Spinner = findViewById(R.id.spinner)
        val option = arrayOf("select","Login", "Sign-up")
        val spinnerAdpter = ArrayAdapter(this@MainPage, android.R.layout.simple_spinner_item, option)
        spinnerAdpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_opt.adapter=spinnerAdpter



        spinner_opt.setOnItemSelectedListener(/* listener = */ object : AdapterView.OnItemSelectedListener {

            override fun  onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position:Int,
                id: Long
            ){


                val selectedItem=option[position]

                    when (selectedItem) {
                        "Login" -> {
                            val intent3 = Intent(this@MainPage, LoginPage::class.java)
                            startActivity(intent3)

                        }

                        "Sign-up" -> {
                            val intent3 = Intent(this@MainPage, SignUp::class.java)
                            startActivity(intent3)


                        }
                        "select"->{
                            updateUsername(textid)
                        }
                    }
                updateUsername(textid)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Toast.makeText(
                    this@MainPage,
                    "Please select an option",
                    Toast.LENGTH_SHORT
                ).show()
            }


        })
        val data1=intent.getStringExtra("data_name")
        val data2=intent.getStringExtra("data_email")
        val data3=intent.getStringExtra("data_gender")
        val data4=intent.getStringExtra("data_number")
        val data5=intent.getStringExtra("data_address")

        val profile:ImageView=findViewById(R.id.profile)
        profile.setOnClickListener{
            val intent=Intent(this,Profile::class.java)
            intent.putExtra("data_name", data1)
            intent.putExtra("data_email", data2)
            intent.putExtra("data_address", data5)
            intent.putExtra("data_number", data4)
            intent.putExtra("data_gender", data3)

            startActivity(intent)
        }



    }
}
