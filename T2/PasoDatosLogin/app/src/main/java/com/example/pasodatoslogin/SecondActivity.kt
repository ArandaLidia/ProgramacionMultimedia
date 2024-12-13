package com.example.pasodatoslogin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pasodatoslogin.databinding.ActivitySecondBinding
import com.example.pasodatoslogin.model.Usuario

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var correo : String
    private lateinit var pass : String
    private var usuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.getSerializableExtra("dato") as Usuario
        binding.texto.text= usuario?.pass ?: "Sin correo"

        /*correo = intent.getStringExtra("correo") ?: "Sin correo"
        pass = intent.getStringExtra("pass") ?: "sin contraseña"

        binding.texto.text = correo
        binding.pass.text = pass*/

    }
}