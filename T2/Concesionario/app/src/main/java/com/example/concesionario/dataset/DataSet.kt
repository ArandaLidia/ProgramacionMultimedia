package com.example.concesionario.dataset

import com.example.concesionario.model.Marca

class DataSet {
    //Lista static
    companion object{
        val lista : ArrayList<Marca> = arrayListOf(Marca("Mercedes", "https://logodownload.org/wp-content/uploads/2014/04/mercedes-benz-logo-0.png"),
            Marca("BMW", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/2048px-BMW.svg.png"),
            Marca("Audi", "https://media.printables.com/media/prints/321186/images/2772740_6ba3a5b5-a72c-4528-b5e1-d60caab08965/thumbs/cover/800x800/png/audi_logo-300x300.webp"),
            Marca("Ford", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTugkBmCLF_giILpgSWeZ8t2DzdL7rNmT4s7w&s")
        )
        fun agregarDatos(marca: Marca){
            this.lista.add(marca)
        }
    }
}