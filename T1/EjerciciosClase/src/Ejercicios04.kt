//4. Escribe un programa que lea un número entero y determine si es par o impar (el if es igual que en Java)

fun main(){
    println("Introduce un número entero para saber si es par o impar:")
    var entero : Int= readln().toInt()

    var resto : (Int) -> Int ={ entero ->
        entero%2
    }
    var resultado = resto(entero)
    fun esPar (){
        if(resultado==0){
            println("El numero ${entero} es par.")
        }else
            println("el numero ${entero }es impar.")
    }

    esPar()
}