package com.example.pasodatoslogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pasodatoslogin.databinding.ActivityMainBinding
import com.example.pasodatoslogin.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.botonLogin.id -> {
                if (binding.editCorreo.text.isNotEmpty()&&binding.editPass.text.isNotEmpty()){
                    if (binding.editPass.text.toString().equals("1234", true)&& binding.editCorreo.text.toString().equals("admin@gmail.com", true)){
                        val intent = Intent(applicationContext, SecondActivity::class.java)
                        //intent.putExtra("correo", binding.editCorreo.text.toString())
                        //intent.putExtra("pass", binding.editPass.text.toString())

                        intent.putExtra("dato", Usuario(binding.editCorreo.text.toString(), binding.editPass.text.toString()))
                        startActivity(intent)
                    }else{
                        Snackbar.make(binding.root, "Fallo en los credenciales", Snackbar.LENGTH_SHORT).show()
                    }
                }else{
                    Snackbar.make(binding.root, "Faltan datos por rellenar", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}
