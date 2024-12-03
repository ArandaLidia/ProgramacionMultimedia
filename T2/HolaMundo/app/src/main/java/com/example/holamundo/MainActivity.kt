package com.example.holamundo

// Importaciones necesarias para este archivo.
// Estas son librerías que proporcionan funcionalidades específicas utilizadas en tu actividad.
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

// Definición de la clase `MainActivity`.
// Esta clase hereda de `AppCompatActivity`, que es una clase base para actividades compatibles con versiones modernas de Android.
class MainActivity : AppCompatActivity() {

    // **Declaración de variables**:
    // - Se utilizan para representar los botones definidos en el archivo XML.
    // - `lateinit` permite declarar variables que serán inicializadas más adelante, pero que deben ser no nulas.
    private lateinit var boton: Button // Representa el botón principal.
    private lateinit var botonAdicional: Button // Representa el botón secundario.

    // Método `onCreate`:
    // - Este método se ejecuta al inicio de la actividad, similar al constructor en otras clases.
    // - Aquí se configuran los elementos visuales y las acciones asociadas a los botones.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // **Modo Edge-to-Edge**:
        // - Llama al método `enableEdgeToEdge`, que ajusta la interfaz para pantallas modernas sin bordes físicos visibles.
        // - Esto asegura que el contenido abarque toda la pantalla, incluyendo áreas donde solían estar las barras de navegación o estado.
        enableEdgeToEdge()

        // **Asociación del diseño XML**:
        // - El método `setContentView` enlaza el archivo XML `activity_main` como el diseño principal de la actividad.
        // - Esto es lo que define cómo se verá la interfaz gráfica.
        setContentView(R.layout.activity_main)

        // **Inicialización del primer botón**:
        // - `findViewById` se utiliza para encontrar un elemento del diseño XML por su ID.
        // - En este caso, busca el botón con ID `BotonPulsar` y lo asigna a la variable `boton`.
        boton = findViewById(R.id.BotonPulsar)

        // **Configuración del evento "clic" para el botón principal**:
        // - `setOnClickListener` define la acción que se ejecutará cuando el usuario pulse este botón.
        boton.setOnClickListener {
            // **Mostrar un Snackbar**:
            // - Un Snackbar es un mensaje emergente que aparece en la parte inferior de la pantalla.
            // - En este caso, muestra el mensaje "Primera app Android completada".
            Snackbar.make(boton, "Primera app Android completada", Snackbar.LENGTH_LONG).show()
        }

        // **Inicialización del segundo botón**:
        // - Similar al primer botón, encuentra el botón con ID `botonSecundario` en el diseño XML.
        botonAdicional = findViewById(R.id.botonSecundario)

        // **Configuración del evento "clic" para el botón adicional**:
        // - Este botón mostrará un mensaje tipo Toast cuando se pulse.
        botonAdicional.setOnClickListener {
            // **Mostrar un Toast**:
            // - Un Toast es otro tipo de mensaje emergente que aparece brevemente en la pantalla.
            // - A diferencia del Snackbar, no tiene acciones asociadas.
            // - Aquí muestra el mensaje "Otro botón pulsado".
            Toast.makeText(applicationContext, "Otro botón pulsado", Toast.LENGTH_LONG).show()
        }

        // **Ajuste de márgenes para el diseño principal**:
        // - Este código asegura que los elementos del diseño no se solapen con las barras del sistema (como la barra de estado o navegación).
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // **Obtener las áreas ocupadas por las barras del sistema**:
            // - Se utiliza `insets.getInsets` para obtener las dimensiones de las barras de estado y navegación.
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // **Aplicar padding**:
            // - Se establece un relleno (padding) en el diseño principal para respetar estas áreas y evitar que el contenido quede detrás de las barras.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            // Devuelve los insets para que el sistema los aplique correctamente.
            insets
        }
    }
}
