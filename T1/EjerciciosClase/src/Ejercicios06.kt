//6. Escribe un programa que calcule el factorial de un número ingresado por el usuario.

fun main(){

    println("Introduce un número para calcular su factorial: ")
    var num : Int = readln().toInt()

    var factorial : Long = 1

    for (i in 1..num){
        factorial *= i


    }


    println("El factorial de ${num} es ${factorial}")

}