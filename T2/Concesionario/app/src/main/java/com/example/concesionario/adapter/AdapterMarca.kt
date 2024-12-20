package com.example.concesionario.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.concesionario.R
import com.example.concesionario.model.Marca
import org.w3c.dom.Text

class AdapterMarca(var lista:ArrayList<Marca>, var context : Context): BaseAdapter() {

    override fun getCount(): Int {
        //Retorna el número de filas que se representan en el spinner
        return lista.size
    }

    override fun getItem(p0: Int): Marca {
        //Retorna el elemento de la posicion -> Seleccionado
        return lista[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    fun agregarMarca(marca: Marca){
        lista.add(marca)
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_marca, p2, false)

        val marca : Marca = lista[p0]
        val imagen: ImageView = vista.findViewById(R.id.imagenspMarca)
        val texto : TextView = vista.findViewById(R.id.textospMarca)
        texto.text = marca.nombre
        Glide.with(context).load(marca.imagen).placeholder(R.drawable.imagen).into(imagen)
        return vista
    }
}