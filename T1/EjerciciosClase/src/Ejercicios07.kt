//7. Escribe un programa que simule una calculadora básica. El programa debe pedir al usuario dos números y una operación (suma, resta, multiplicación, división) y mostrar el resultado.

fun main(){

    println("Introduce el operando 1: ")
    var op1 : Int = readln().toInt()
    println("Introduce el operando 2: ")
    var op2 : Int = readln().toInt()
    println("Introduce una operación: (+ , - , * , /)")
    var operacion :String = readln()


     var resultado : Int=0
    fun calculadora (num1:Int, num2: Int) {
        if (operacion.equals("+")) {
            resultado = num1+num2
        }else if (operacion.equals("-")){
            resultado=num1-num2
        }else if (operacion.equals("*")){
            resultado = op1*op2
        }else if (operacion.equals("/")){
            if (op2==0){
                println("Número no válido")
            }else{
                resultado = op1/op2
            }
        }
    }
    calculadora(op1, op2)
    println("El resultado de ${op1} ${operacion} ${op2 } es ${resultado}")
}