package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var totalV: TextView;
    private lateinit var dollarV : LinearLayout;
    private lateinit var tenCentsV : LinearLayout;
    private lateinit var quaterCentsV: LinearLayout;
    private lateinit var fiveCentsV : LinearLayout;


    private var total = 0.00;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportActionBar!!.hide();

        bind()

        addListeners()
    }

    private fun bind(){

        quaterCentsV = findViewById(R.id.quater);
        dollarV = findViewById(R.id.dollar);
        totalV = findViewById(R.id.cant);
        fiveCentsV= findViewById(R.id.five_cents);
        tenCentsV = findViewById(R.id.ten_cents);


    }

    private fun addListeners(){

        fiveCentsV.setOnClickListener{
            total += 0.05;
            AddValue();
        }

        quaterCentsV.setOnClickListener{
            total += 0.25;
            AddValue();
        }
        dollarV.setOnClickListener{
            total += 1.00;
            AddValue();
        }

        tenCentsV.setOnClickListener{
            total += 0.10;
            AddValue();
        }
    }

    private fun AddValue(){
        totalV.text = getString(R.string.total_amount, String.format("%.2f", total));
    }
}