package com.michelle.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameInput : TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var numberInput: TextInputEditText
    private lateinit var ButtonOne: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()
        addListener()
    }

    private fun bind() {
        nameInput = findViewById(R.id.name_input)
        emailInput = findViewById(R.id.email_input)
        numberInput = findViewById(R.id.number_input)
        ButtonOne= findViewById(R.id.ButtonOne)
    }

    private fun addListener() {
        ButtonOne.setOnClickListener {
            val intent = Intent(MainActivity@this, SecondActivity::class.java)

            val namei = nameInput.text.toString()
            val emaili = emailInput.text.toString()
            val numberi = numberInput.text.toString()

            intent.putExtra("name", namei)
            intent.putExtra("email", emaili)
            intent.putExtra("number", numberi)

            startActivity(intent)
        }
    }
}
