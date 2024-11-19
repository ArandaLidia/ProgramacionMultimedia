//9. Escribe un programa que maneje información de usuarios, donde algunos campos pueden ser opcionales
// (es decir, pueden ser null). En el programa, ni el apellido ni la edad pueden ser null.
// Si no se proporciona la edad, debes manejar un valor por defecto. Crear una función que reciba el nombre,
// apellido y edad y devuelva un mensaje con la información completa del usuario. Maneja de forma segura los posibles nulos

fun main(){
    println("Introduce tu  nombre")
    var nombre : String? = readln()
    println("Introduce tu  apellido")
    var apellidos : String = readln()
    if (apellidos==""){
        println("Lo siento, apellido no válido")
    }
    println("Introduce tu  edad")
    var edad : Int = readln().toInt()
    if (edad==null){
        println("Lo siento, edad no válida")
    }
    println("Introduce tu  teléfono")
    var telefono : String? = readln()
    println("Introduce tu  correo")
    var correo : String? = readln()

}