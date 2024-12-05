package com.example.seleccion.model

//Todos los elementos de android se pueden tratar como numeros r.XXXXXX -> da un número, por eso imagen: String

class Marca (var titulo: String, var anio: Int,var imagen: Int){
    override fun toString(): String {
        return titulo + " "+ anio
    }
}