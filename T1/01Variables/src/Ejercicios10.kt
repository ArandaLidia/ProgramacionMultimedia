//Declara una variable llamada "nombreCompleto" de tipo String y asígnale tu nombre completo.

class Ejercicios10 {
var nombreCompleto : String ="Lidia Aranda"
fun asignarNombre(){
    var nombreCompleto1 :String
    nombreCompleto1 ="Lidia Aranda"
}

    var asignarEdad: (Int) -> Boolean = { edad: Int ->
        if (edad > 18) {
            println("Es mayor de edad")
            true  // Retorna true si es mayor de edad
        } else {
            println("No es mayor de edad")
            false  // Retorna false si no es mayor de edad
        }
        

    }

}