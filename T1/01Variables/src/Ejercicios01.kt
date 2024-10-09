//Ejercicios de clase

//1. Declara una variable llamada "nombre" de tipo String y asígnale tu nombre.

    fun main(){
        var nombre: String = "Lidia"
//Declarar variable con lateinit e inicializarla dentro de funcion
        lateinit var nombre1: String


        fun asignarNombre():String{
            var nombre1 = "Lidia Aranda"
            return nombre1
        }

        println("El nombre completo es ${asignarNombre()}")
    }



