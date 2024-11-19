package com.example.holamundo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var boton: Button;
    private lateinit var botonAdicional: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        boton=findViewById(R.id.BotonPulsar)
        boton.setOnClickListener{
            Snackbar.make(boton, "Primera app Android completada", Snackbar.LENGTH_LONG).show()
        }
        botonAdicional=findViewById(R.id.botonSecundario)
        botonAdicional.setOnClickListener{
            Toast.makeText(applicationContext, "Otro botón pulsado", Toast.LENGTH_LONG).show()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}