package com.example.appmapas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton = findViewById(R.id.activity_main_maps)
//Evento
        boton.setOnClickListener(){onClick()}
    }//onCreate
    fun onClick() {
        val intent: Intent?
        intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }//onClick
}//class