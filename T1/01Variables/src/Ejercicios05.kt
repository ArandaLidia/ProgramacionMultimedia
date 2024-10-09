//5. Declara una variable llamada "listaDeNombres" de tipo List<String> y asígnale una lista con los nombres de tus tres mejores amigos.

    fun main(){
        var listaDeNombres : List<String> = listOf("Maria","Vanesa","Emma")

        fun agregarNombres (): List<String>{
            var listaNombres1 : List<String>
            listaNombres1= listOf("Caro", "Rocio", "Noelia")
            return listaNombres1
        }
        println("Los nombres de mis mejores amigas son: ${agregarNombres()}")
    }
