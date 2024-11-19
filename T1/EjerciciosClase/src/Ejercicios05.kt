//5. Escribe un programa que lea dos números enteros y determine cuál es mayor.

fun main() {
    println("Introduce  un número:")
    var num1 : Int = readln().toInt()
    println("Introduce otro número:")
    var num2: Int = readln().toInt()

    fun esMayor (){
        if (num1>num2){
            println("El número ${num1} es mayor que ${num2}")
        }else
            println("El número $num2 es mayor que ${num1}")
    }

    esMayor()
}