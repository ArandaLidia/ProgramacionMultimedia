/*1. Escribe un programa que pida al usuario dos números enteros y calcule su suma.*/


fun main(){
    // Leer los dos números desde la consola
    println("Ingresa el primer número entero:")
    val operando1: Int = readln().toInt()

    println("Ingresa el segundo número entero:")
    val operando2: Int = readln().toInt()

    // Función para calcular la suma
    fun suma() {
        val resultado = operando1 + operando2
        println("El resultado de la suma de $operando1 + $operando2 es $resultado")
    }
    //Funcion lambda
    val suma: (Int, Int) -> Int = { num1, num2 ->
        num1 + num2
    }

    // Llamada a la función lambda con los valores operando1 y operando2
    val resultado = suma(operando1, operando2)

    println("El resultado de la suma de $operando1 + $operando2 es $resultado")
    // Llamada a la función

    suma()
}