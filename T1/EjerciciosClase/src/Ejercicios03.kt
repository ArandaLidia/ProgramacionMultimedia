//3. Escribe un programa que convierta grados Celsius a Fahrenheit. Usa la fórmula: F = C * 9/5 + 32.


fun main(){
    println("Introduce los grados Celsius que quieras pasar a grados Fahrenheit")
    var grados : Double = readln().toDouble()

    var fahrenheit : (Double) -> Double = { grados ->
        grados*5/9+32
    }

    var resultado = fahrenheit(grados)

    println("${grados}º Celsius son ${resultado}º Fahrenheit")
}