package com.example.seccion

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seccion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnComprobar.setOnClickListener(this)
        binding.toggleSelection.setOnCheckedChangeListener(this)

    }

    override fun onClick(v: View?) {
when (v?.id){
    binding.btnComprobar.id -> {
        Snackbar.make(binding.root, "El estado del toggle es ${binding.toggleSelection.isChecked}", Snackbar.LENGTH_SHORT).show()

    }
}
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            binding.toggleSelection.id ->{
                binding.textoToggle.text = isChecked.toString()
            }
        }
    }
}