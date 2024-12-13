package com.example.appimc

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.appimc.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera el Bundle de la Intent de forma segura
        val bundleRecup = intent.getBundleExtra("datos")

        // Verifica si el Bundle no es nulo antes de usarlo
        if (bundleRecup != null) {
            val altura = bundleRecup.getDouble("altura", 0.0) // Devuelve 0.0 si la clave no existe
            val peso = bundleRecup.getDouble("peso", 0.0) // Devuelve 0.0 si la clave no existe

            // Muestra los valores en el TextView (asegurando que el valor no sea 0.0 si no es válido)
            if (altura != 0.0) {
                binding.txtAltura.setText(altura.toString())

            } else {
                binding.txtAltura.setText("Valor no válido")
            }

            if (peso != 0.0) {
                binding.txtPeso.setText(peso.toString())
            } else {
                binding.txtPeso.setText("Valor no válido")
            }
        } else {
            // Muestra un mensaje de error si no se recibieron datos
            Snackbar.make(binding.root, "No se recibieron datos", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnCalcular.setOnClickListener(this)
        val altura = binding.txtAltura.setOnClickListener(this)
        val peso= binding.txtPeso.setOnClickListener(this);
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> {

            }
        }
    }
}
