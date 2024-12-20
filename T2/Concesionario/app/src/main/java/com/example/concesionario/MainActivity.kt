package com.example.concesionario

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.concesionario.adapter.AdapterMarca
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.dataset.DataSet
import com.example.concesionario.model.Marca
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarca: AdapterMarca
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
    }
    private fun instancias(){

        adapterMarca = AdapterMarca(DataSet.lista, applicationContext)
        binding.spinnerMarca.adapter = adapterMarca

        acciones()
    }

    private fun acciones(){
        binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val marca : Marca = adapterMarca.getItem(p2)
               // Log.v("marca", "Seleccionado ${marca.nombre}")  -> PAra que salga en LogCat
                //Para que salga en pantalla....
                Glide.with(applicationContext).load(marca.imagen).placeholder(R.drawable.imagen).into(binding.imagenMarca)
                }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
binding.botonFiltro.setOnClickListener {
    DataSet.agregarDatos(Marca("cosa", ""))
}
        }
    }
