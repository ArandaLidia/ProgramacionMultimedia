package com.example.contador

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding

//PRIMERO : EN BUILD.GRADLE.KTS viewBinding { enable = true } y sincronizar
//SEGUNDO: CREAR VARIABLE EN MAINACTIVITY: private lateinit var: activity var binding: ActivityMainBinding
//TERCERO: inicializar variable despues super.onCreate -> binding = ActivityMainBinding.inflate(layoutInflater)
//ULTIMO: setContentView(binding.root)


//PONER A ESCUCHAR BOTONES: - implementar OnClickListener
                        //  - binding.btnDecremento.setOnClickListener (this) **Todos los botones que se vayan a usar
//EN CLASS MainActivity: IMPLEMENTAR metodo -> Aparece override fun onClick (v: View?)

//RELLENAR METODO FUNONCLICK con swicht -> when (v?.id) ->{ binding.btnDecremento.id -> { LLAMAR AL METODO CON LA LOGICA}     } ponemos v? porque puede ser nulo.

//Que el textContador coja el texto de contador: binding.textocontador.text = contador  -> 1º es strig, el 2º es int. hay que castear: contador.toString()


//GUARDAR APP PARA GIRO DE PANTALLA
//onSaveInstanceState(outState:Bundle) {} ->SOverride
//super.onSaveInstanceState(outState)

//-> Ponemos: outState.punInt("contador", contador)  **Podemos guardar tantas cosas como queramos
// "contador" -> etiqueta , contador ->variable


//RECUPERAR SAVEINSTACESTATE  -> DESPUES DE BINDING.ROOT SI ES GRAFICO
//guardar putInt recuperar getInt
//savedInstanceState.getInt("contador") -> etiqueta || Sale error poner ? -> savedInstanceState?.getInt("contador") -> etiqueta
//Guardarla en la variable contador = savedInstanceState?.getInt("contador") -> etiqueta
//Da error porque puede ser nulo y hemos puesto que es int -> operador elvis -> contador = savedInstanceState?.getInt("contador") ?:0  -> Si no es int y es nulo lo iguala a 0.


//LANDSCAPE:  como el boton restart solo está en horizontal el binding del boton se pone con ?, ya que puede ser nulo porque en vertical ese boton no está
// binding.btnRestart?.setOnClickListener(this)

//IDIOMAS
//<!--NEW VALUES RESOURCES llamarle de la misma manera : String , valor Locale, elegir idioma.
//En la nueva ventana copiar los string, dar a abrir editor, y actualizar, cambiar la palabra al idioma.

//En activity main, en el boton poner: android:text="@string/restart"


class MainActivity : AppCompatActivity(), OnClickListener {
    // Declaración de una variable para gestionar la vinculación con las vistas (View Binding).
    //La mayoría de variables que se declaran en androidStudio son lateinit, se inicializan despues, no aquí
    private lateinit var binding: ActivityMainBinding  //Si creas otra ventana, tambien se declara la variable

    // Variable para almacenar el valor actual del contador. Se inicializa en 0.
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflamos el layout utilizando View Binding. Esto permite un acceso más seguro y directo a las vistas.
        binding = ActivityMainBinding.inflate(this.layoutInflater) //LayoutInflater hace que se pueda usar el ActivityMainBinding

        // Asocia el diseño gráfico al código lógico de la actividad.
        setContentView(binding.root)

        // Restauración del valor del contador en caso de que la actividad sea recreada (por ejemplo, rotación de pantalla).
        contador = savedInstanceState?.getInt("contador") ?: 0

        // Actualizamos el `TextView` del contador con el valor actual.
        binding.textoContador.text = contador.toString()

        // Configuramos los botones para que reaccionen a los clics.
        // Como esta clase implementa `OnClickListener`, usamos `this` como referencia.
        binding.btnDecremento.setOnClickListener(this)
        binding.btnIncremento.setOnClickListener(this)

        // Este botón es opcional (puede no existir en el diseño), por eso usamos el operador seguro `?.`
        binding.btnRestart?.setOnClickListener(this)

        // Registro en el log para rastrear el ciclo de vida de la actividad.
        Log.v("ciclo_vida", "Ejecutando onCreate")
    }

    // Método de la interfaz `OnClickListener` para gestionar eventos de clic en los botones.
    override fun onClick(v: View?) {
        // Identificamos qué botón ha sido pulsado mediante su ID.
        when (v?.id) {
            binding.btnDecremento.id -> {
                // Si se pulsa el botón de decremento, se resta 1 al contador.
                contador--
            }
            binding.btnIncremento.id -> {
                // Si se pulsa el botón de incremento, se suma 1 al contador.
                contador++
            }
            binding.btnRestart?.id -> {
                // Si se pulsa el botón de reinicio (si existe), el contador vuelve a 0.
                contador = 0
            }
        }
        // Se registra en el log el valor actual del contador para fines de depuración.
        Log.v("valor_contador", contador.toString())

        // Se actualiza el valor mostrado en el `TextView` con el nuevo valor del contador.
        binding.textoContador.text = contador.toString()
    }

    // Este método se llama cuando la actividad se destruye.
    override fun onDestroy() {
        super.onDestroy()
        // Registro en el log para indicar que se está ejecutando `onDestroy`.
        Log.v("ciclo_vida", "Ejecutando onDestroy")
    }

    // Este método se llama cuando la actividad vuelve a estar visible para el usuario.
    override fun onResume() {
        super.onResume()
        // Registro en el log para indicar que se está ejecutando `onResume`.
        Log.v("ciclo_vida", "Ejecutando onResume")
    }

    // Este método se llama cuando la actividad ya no es visible para el usuario.
    override fun onStop() {
        super.onStop()
        // Registro en el log para indicar que se está ejecutando `onStop`.
        Log.v("ciclo_vida", "Ejecutando onStop")
    }

    // Este método se llama cuando la actividad se reinicia después de haber sido detenida.
    override fun onRestart() {
        super.onRestart()
        // Registro en el log para indicar que se está ejecutando `onRestart`.
        Log.v("ciclo_vida", "Ejecutando onRestart")
    }

    // Este método se llama antes de que la actividad sea destruida, para guardar el estado actual.

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guardamos el valor del contador en el `Bundle` para que pueda restaurarse más tarde.
        outState.putInt("contador", contador)
    }
}