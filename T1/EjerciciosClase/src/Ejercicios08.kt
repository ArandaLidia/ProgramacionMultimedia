fun main() {
    println("Introduce un número para saber si es primo: ")
    val num: Int = readln().toInt()

    fun esPrimo(num: Int): Boolean {
        if (num < 2) {
            return false
        }
        for (i in 2 until num) {
            if (num % i == 0) {
                return false
            }
        }
        return true //
    }

    if (esPrimo(num)) {
        println("${num} es un número primo.")
    } else {
        println("${num} no es un número primo.")
    }
}
