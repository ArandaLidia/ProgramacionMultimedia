package com.example.seleccion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seleccion.databinding.ActivityCochesBinding
import com.example.seleccion.databinding.ActivityMainBinding
import com.example.seleccion.model.Marca
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

/*
1ºTIPO DE DATO SPINNER: SOLO STRING -> Sin personalizar gráficamente : estáticos

************* ACCEDER A LOS ELEMENTOS DESPUÉS DEL CAMBIO DE SELECCIÓN: y mostrar en Snackbar
* //No pueden cambiar los datos porque es un array con datos fijos, no dinámicos,
* por lo tanto se pueden coger directamente del spinner.
*
*   Dentro de binding.botonMarcas.setOnClickListener {
*       val marca: String = binding.spinnerMarcas.selectedItem.toString()
*       Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT).show()
*   }
*
*********** ACCEDER A LOS ELEMENTOS DIRECTAMENTE AL CAMBIAR EL SPINNER, SIN BOTÓN PULSAR : posteriori
*
*      * Implementar onClickListener e implementar members para que aparezca el método override fun onClick.
*      * En este caso, dentro de acciones() { poner a escuchar los botones: binding.botonMarcas.setOnClickListener(this) }
*      * Para el spinner: setOnItemSelectedListener: binding.spinnerMarcas.setOnItemSelectedListener -- No es onClick porque tiene dos métodos.
*
*      * Dos soluciones:
*        1º (Solo un objeto Spinner)
*           binding.spinnerMarcas.onItemSelectedListener = object : OnItemSelectedListener { }
*           IMPLEMENTAR MEMBERS y aparecen 2 métodos.
*
*        2º (Más de un spinner)
*           * Implementar en OnItemSelectedListener(AdapterView)
*           * Implementar members y aparecen dos métodos: override fun onItemSelected() y override fun onNothingSelected().
*           * En acciones: binding.spinnerMarcas.onItemSelectedListener = this (Se refiere a la parte de la clase selectedListener).
*
*           - Método onItemSelected:
*             - parent: el elemento que ha provocado la acción -> when (cuando hay varios spinners).
*             - view: la fila que se ha seleccionado, pero en modo view (raro que lo usemos).
*             - position: La posición seleccionada del spinner (usa a menudo).
*             - id: ID de la posición seleccionada (usado en base de datos).
*
*           ** SACAR MARCA SELECCIONADA **
*           val marca: String = binding.spinnerMarcas.selectedItem.toString() // Se puede usar porque son datos fijos.
*           Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT).show()
*
*           ******* De manera más eficiente:
*           val marca: String = parent!!.adapter.getItem(position).toString()
*           -> Se pone !! porque no puede ser nulo, ya que salta cuando se selecciona un ítem.

2ºTIPO DE DATO: CUALQUIER TIPO DE DATO  -> Sin personalizar gráficamente -> Dinámicos.
-Crear modelo en clase Kotlin:
  * class Marca(var titulo: String, var anio: Int, var imagen: Int) {
  *     override fun toString(): String {
  *         return titulo + " " + anio
  *     }
  * }

  **Nota sobre elementos de Android:**
  Todos los elementos de Android (como imágenes o recursos) se pueden tratar como números usando `r.XXXXX`.
  Por ejemplo, en el modelo `Marca`, el campo `imagen` está definido como un `Int` porque corresponde al identificador del recurso.

-Crear un ArrayList dinámico:
  * En onCreate: private lateinit var listaMarcas: ArrayList<Marca>
  * En método instancias():
    listaMarcas = arrayListOf(
      Marca("Mercedes", 1897, -1),
      Marca("Ford", 1877, -1),
      Marca("Audi", 1897, -1),
      Marca("BMW", 1827, -1)
    )

-Configurar adaptador:
  * Necesitamos un objeto de tipo `ArrayAdapter`: private lateinit var adaptadorMarcasSpinner: ArrayAdapter<Marca>
  * En instancias(): inicializamos el adaptador:
    adaptadorMarcasSpinner = ArrayAdapter(
      applicationContext,
      android.R.layout.simple_spinner_item,
      listaMarcas
    )
    adaptadorMarcasSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    binding.spinnerMarcasDinamico.adapter = adaptadorMarcasSpinner

-Añadir acción al seleccionar del spinner:
  * En acciones(): binding.spinnerMarcasDinamico.onItemSelectedListener = this
  * En onItemSelected():
    when(parent?.id) {
      binding.spinnerMarcasDinamico.id -> {
        val marca: Marca = parent!!.adapter.getItem(position) as Marca
        Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT).show()
      }
    }
*/


class CochesActivity : AppCompatActivity(), OnClickListener, OnItemSelectedListener {
    // Variable que contiene los elementos de la interfaz de usuario definidos en el layout
    private lateinit var binding: ActivityCochesBinding

    // Lista para almacenar las marcas de coches
    private lateinit var listaMarcas: ArrayList<Marca>

    // Adaptador que vincula la lista de marcas con el spinner (desplegable)
    private lateinit var adaptadorMarcasSpinner: ArrayAdapter<Marca>

    // Método que se ejecuta al iniciar la actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos la variable que vincula los elementos del diseño (XML) con el código
        binding = ActivityCochesBinding.inflate(layoutInflater)

        // Configuramos el diseño de la actividad para que ocupe toda la pantalla y se vea mejor
        enableEdgeToEdge()

        // Asignamos el diseño de la actividad a la pantalla
        setContentView(binding.root)

        // Definimos las acciones que se ejecutarán al interactuar con los elementos de la interfaz
        acciones()

        // Inicializamos la lista de marcas y configuramos los adaptadores para los spinners
        instancias()
    }

    // Método que configura las instancias de los elementos necesarios, como la lista de marcas y los adaptadores
    private fun instancias() {
        // Creamos una lista con objetos de tipo Marca, cada uno con un nombre y año
        listaMarcas = arrayListOf(
            Marca("Mercedes", 1897, -1),
            Marca("Ford", 1877, -1),
            Marca("Audi", 1897, -1),
            Marca("BMW", 1827, -1)
        )

        // Configuramos un adaptador que vincula la lista de marcas con el spinner
        adaptadorMarcasSpinner = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaMarcas)

        // Definimos cómo se mostrará cada elemento del desplegable al seleccionarlo
        adaptadorMarcasSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Asociamos el adaptador al spinner dinámico
        binding.spinnerMarcasDinamico.adapter = adaptadorMarcasSpinner
    }

    // Método que define las acciones para los elementos interactivos de la interfaz
    private fun acciones() {
        // Configuramos las acciones para los botones "Buscar" y "Nuevo"
        binding.botonBuscar.setOnClickListener(this)
        binding.botonNuevo.setOnClickListener(this)

        // Configuramos los listeners para detectar selecciones en los spinners
        binding.spinnerMarcas.onItemSelectedListener = this
        binding.spinnerMarcasDinamico.onItemSelectedListener = this
    }

    // Método que se ejecuta cuando se hace clic en alguno de los botones
    override fun onClick(v: View?) {
        // Identificamos el botón que se ha presionado mediante su ID
        when (v?.id) {
            // Acción para el botón "Buscar"
            binding.botonBuscar.id -> {
                // Obtenemos la marca seleccionada en el spinner fijo
                val marca: String = binding.spinnerMarcas.selectedItem.toString()

                // Mostramos un mensaje indicando la marca seleccionada
                Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT).show()
            }

            // Acción para el botón "Nuevo"
            binding.botonNuevo.id -> {
                // Cambiamos a otra pantalla (MainActivity)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // Método que se ejecuta al seleccionar un elemento de un spinner
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Identificamos el spinner que activó el evento mediante su ID
        when (parent?.id) {
            // Si se trata del primer spinner
            binding.spinnerMarcas.id -> {
                // Obtenemos la marca seleccionada y mostramos un mensaje con su nombre
                val marca: String = parent.adapter.getItem(position).toString()
                Snackbar.make(binding.root, "La marca seleccionada es ${marca}", Snackbar.LENGTH_SHORT).show()
            }

            // Si se trata del spinner dinámico
            binding.spinnerMarcasDinamico.id -> {
                // Obtenemos el objeto Marca seleccionado y mostramos un mensaje con su año
                val marca: Marca = parent.adapter.getItem(position) as Marca
                Snackbar.make(binding.root, "La marca seleccionada es del año ${marca.anio}", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    // Método que se ejecuta si no se selecciona nada en un spinner
    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Por ahora no realizamos ninguna acción
        TODO("Not yet implemented")
    }
}
