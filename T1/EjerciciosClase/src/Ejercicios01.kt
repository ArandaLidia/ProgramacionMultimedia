/*1. Escribe un programa que pida al usuario dos números enteros y calcule su suma.



7. Escribe un programa que simule una calculadora básica. El programa debe pedir al usuario dos números y una operación (suma, resta, multiplicación, división) y mostrar el resultado.
8. Escribe un programa que determine si un número ingresado por el usuario es primo
9. Escribe un programa que maneje información de usuarios, donde algunos campos pueden ser opcionales (es decir, pueden ser null). En el programa, ni el apellido ni la edad pueden ser null. Si no se proporciona la edad, debes manejar un valor por defecto. Crear una función que reciba el nombre, apellido y edad y devuelva un mensaje con la información completa del usuario. Maneja de forma segura los posibles nulos

*/


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