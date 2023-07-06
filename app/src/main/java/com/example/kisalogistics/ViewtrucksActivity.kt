package com.example.kisalogistics

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class ViewtrucksActivity : AppCompatActivity() {
    lateinit var cardcherrypicker:CardView
    lateinit var cardscissorlift:CardView
    lateinit var cardterrain:CardView
    lateinit var cardginerich:CardView
    lateinit var cardtelehandler:CardView
    lateinit var cardtruckmounted:CardView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewtrucks)
        cardcherrypicker = findViewById(R.id.mcardcherrypicker)
        cardscissorlift = findViewById(R.id.mcardscissorlift)
        cardterrain = findViewById(R.id.mcardterrain)
        cardginerich = findViewById(R.id.mcardginerich)
        cardtelehandler = findViewById(R.id.mcardtelehandler)
        cardtruckmounted = findViewById(R.id.mcardtruckmounted)

        cardcherrypicker.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }
        cardscissorlift.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }
        cardterrain.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }
        cardginerich.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }
        cardtelehandler.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }
        cardtruckmounted.setOnClickListener {
            startActivity(Intent(this, ViewchargesActivity::class.java))
        }

    }
}