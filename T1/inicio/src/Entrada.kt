//constructor
    //variables
    //funciones (fuera de la clase tambien se pueden hacer funciones) Cuando hay una fuera del metodo, ya no es clase, ya es un fichero.

//Class Entrada {psvm(String[]arg}
//fun nombre (nombreArgs: Tipo, nombreArgs: Tipo, nombreArgs: tipo: Retorno {CUERPO}
fun main (args: Array<String>){
    println("Primera app kotlin")

    //VARIABLES: VAR -> Modifican el valor a lo largo de su vida  VAL -> NO modifican el valor
    //TIPO nombre: TIPO=valor

    var nombre = "Lidia"
    var edad= 37
    val experiencia = true; //No puede cambiar su valor

    var apellido: String?="null" //null  ->Para poder guardar null, hay que poner interrogación detras del tipo
    //Nullpointerexception -> null safety -> Garantia que no va a dar error poner !! exclamaciones detras nombre de variable.  println(apellido!!.lenght)
    //Hay que estar muy seguro de que no va a ser nulo
    println(apellido?.length) //Si no es nulo, imprime la longitud, si es nulo imprime null
    println(apellido?.length ?: "No se encuentra el apellido") // Si es nulo, imprime lo que hay detras de ?:

    //lateinit, son variables que van a tener un valor, pero se inicializan sin valor
    lateinit var correo: String
    correo = "lidia@gmail.com"
    println(correo)

    //Complejas -> Primera letra en mayuscula en el tipo -> String, Date, ArrayList
    //simples -> primera minustucla en el tipo -> int, double, float, boolean+      /
            //wrapper -> Integer, Double, Float, Boolean
    //Primitivas no se pueden poner  lateinit , si como posible nulo Int?

    //sout("asfadsfsaf "+variable+ "sfsfdgsdgf")
    //souf("dasfdasfas %s asdfdasfasdf ", variable)


println("Mi nombre $nombre, mi apellido es ${apellido?: "sin definir "} "+ "y mi correo es $correo")



    fun sumar(operando1:Int, operando2: Int){
        println("El resultado de la operación es ${operando1+operando2}")
    }
    //posicional
    sumar(5,10)
    //nominal
    sumar(operando1 = 10, operando2 = 50 )

    //valores por defecto
sumar(7)
}