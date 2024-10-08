
//2. Escribe un programa que pida el radio de un círculo y calcule su área. Utiliza la fórmula Área = π * radio^2.

fun main(){
    println("Introduce el radio")
    var radio = readln().toInt()

    var area : (Int) -> Double = { radio ->
        Math.PI*radio*2
    }

    var resultado = area(radio)

    println("El area de un circulo con radio: ${radio} es: ${resultado}")
}