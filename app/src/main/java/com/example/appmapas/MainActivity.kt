package com.example.appmapas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botonMapsActivity: Button
    private lateinit var botonShowRoute: Button
    private lateinit var editTextOrigin: EditText
    private lateinit var editTextDestination: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonMapsActivity = findViewById(R.id.activity_main_maps)
        botonMapsActivity.setOnClickListener { openMapsActivity() }

        botonShowRoute = findViewById(R.id.btn_show_route)
        editTextOrigin = findViewById(R.id.editText_origin)
        editTextDestination = findViewById(R.id.editText_destination)

        botonShowRoute.setOnClickListener { showRouteInGoogleMaps() }
    }

    private fun openMapsActivity() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    private fun showRouteInGoogleMaps() {
        // Obtén los nombres de los lugares de los EditText
        val origin = editTextOrigin.text.toString().trim()
        val destination = editTextDestination.text.toString().trim()

        if (origin.isNotEmpty() && destination.isNotEmpty()) {
            val formattedOrigin = origin.replace(" ", "+")
            val formattedDestination = destination.replace(" ", "+")

            // Construye el URI para Google Maps
            val gmmIntentUri = Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$formattedOrigin&destination=$formattedDestination&travelmode=driving")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                Toast.makeText(this, "Error en intent", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Campos vacios.", Toast.LENGTH_LONG).show()
        }
    }
}