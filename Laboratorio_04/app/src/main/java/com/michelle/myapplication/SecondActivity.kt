package com.michelle.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var shareButton: Button
    var emaili: String = ""
    var numberi: String = ""
    var namei: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        emaili = intent.getStringExtra("email") ?: ""
        numberi = intent.getStringExtra("phone") ?: ""
        setContentView(R.layout.activity_second)
        namei = intent.getStringExtra("name") ?: ""

        findViewById<TextView>(R.id.email_text)?.let { it.text = emaili }
        findViewById<TextView>(R.id.number_text)?.let { it.text = numberi }
        findViewById<TextView>(R.id.name_text)?.let { it.text = namei }


        bind()
        addListener()
    }

    private fun bind() {
        shareButton = findViewById(R.id.ShareB)
    }

    private fun addListener() {
        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.thestring, namei, emaili, numberi))
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}