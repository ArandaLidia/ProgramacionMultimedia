package com.example.appimc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appimc.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            // Verifica si los campos de texto no están vacíos y si se ha seleccionado un RadioButton
            if (binding.txtPeso.text.isNotEmpty() && binding.txtAltura.text.isNotEmpty() && binding.radioGrupo.checkedRadioButtonId != -1) {
                // Crea un Bundle con valores de tipo Double
                val bundle = bundle()

                // Crea la Intent y agrega el Bundle como extra
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("datos", bundle)

                // Inicia la actividad
                startActivity(intent)
            } else {
                // Muestra un mensaje de error si los campos no están completos
                Toast.makeText(this, "Necesitas rellenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Método que crea y devuelve un Bundle con valores Double
    private fun bundle(): Bundle {
        return Bundle().apply {
            val altura = binding.txtAltura.text.toString().toDoubleOrNull()
            val peso = binding.txtPeso.text.toString().toDoubleOrNull()

            if (altura != null && peso != null) {
                putDouble("altura", altura)
                putDouble("peso", peso)
            } else {
                throw IllegalArgumentException("Los valores de altura y peso deben ser numéricos válidos.")
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalcular.id -> {
                // Aquí puedes llamar a la lógica de cálculo si es necesario
            }
        }
    }

    // Método para calcular el IMC
    private fun calcularIMC() {
        val alturaTxt = binding.txtAltura.text.toString()
        val pesoTxt = binding.txtPeso.text.toString()

        val altura = alturaTxt.toDoubleOrNull()
        val peso = pesoTxt.toDoubleOrNull()

        if (altura != null && peso != null) {
            val resultadoIMC = peso / (altura * altura)
            // Muestra el resultado de IMC o realiza alguna acción con el resultado
        } else {
            Snackbar.make(binding.root, "Hay datos no válidos", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        // Implementa la lógica para manejar cambios de selección si es necesario
    }
}
