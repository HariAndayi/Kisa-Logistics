package com.example.kisalogistics

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {
    lateinit var cardourtrucks:CardView
    lateinit var cardourcharges:CardView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cardourtrucks = findViewById(R.id.mcardourtrucks)
        cardourcharges = findViewById(R.id.mcardourcharges)

        cardourtrucks.setOnClickListener {
            startActivity(Intent(this, OurtrucksActivity::class.java))
        }
        cardourcharges.setOnClickListener {
            startActivity(Intent(applicationContext,OurchargesActivity::class.java))

        }
    }
}