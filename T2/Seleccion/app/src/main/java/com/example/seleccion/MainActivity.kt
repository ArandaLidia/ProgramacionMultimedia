package com.example.seleccion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seleccion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

// **PASOS PARA CONFIGURAR VIEW BINDING**

// 1. En el archivo `build.gradle.kts`:
//    Habilitar View Binding añadiendo lo siguiente:
//    viewBinding { enable = true }
//    Esto permite acceder directamente a las vistas desde su ID sin usar `findViewById`.
//    Luego, sincronizar el proyecto para aplicar los cambios.

// 2. Declarar una variable en MainActivity para manejar el binding:
//    private lateinit var binding: ActivityMainBinding
//    Se utiliza "lateinit" porque la inicialización se realiza en el método onCreate.

// 3. Inicializar el binding después de `super.onCreate`:
//    binding = ActivityMainBinding.inflate(layoutInflater)
//    Luego, establecer la vista principal:
//    setContentView(binding.root)

// **MANEJO DE EVENTOS DE BOTONES Y OTROS COMPONENTES**

// **CAMBIAR EL ESTADO AL PULSAR EL BOTÓN "COMPROBAR"**
// 1. Configurar un listener en el botón "Comprobar":
//    binding.btnComprobar.setOnClickListener(this)
//    Esto delega el manejo del clic al método onClick.

// 2. En el método `override fun onClick(p0: View?)`:
//    Usar un `when` para identificar qué componente disparó el evento:
//    when (p0?.id) {
//        binding.btnComprobar.id -> {
//            // Mostrar el estado del ToggleButton en un Snackbar:
//            Snackbar.make(
//                binding.root,
//                "El estado del toggle es ${binding.toggleSeleccion.isChecked}",
//                Snackbar.LENGTH_SHORT
//            ).show()
//        }
//    }

// **CAMBIAR RESULTADO AL PULSAR EN EL TOGGLEBUTTON**
// 1. Configurar un listener para el ToggleButton:
//    binding.toggleSeleccion.setOnCheckedChangeListener(this)
//    Esto permite escuchar los cambios de estado del ToggleButton.

// 2. Implementar la interfaz `CompoundButton.OnCheckedChangeListener` en MainActivity:
//    Es necesario implementar el método `onCheckedChanged`.

// 3. Sobrescribir el método de la interfaz:
//    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//        // El parámetro `p1` indica si el componente está activado (true) o desactivado (false).
//        when (p0?.id) {
//            binding.toggleSeleccion.id -> {
//                // Cambiar el texto de un TextView para reflejar el estado actual del ToggleButton:
//                binding.textoToggle.text = p1.toString()
//            }
//        }
//    }

// 4. Alternar el estado del ToggleButton desde el botón "Comprobar":
//    when (p0?.id) {
//        binding.btnComprobar.id -> {
//            // Cambiar el estado del ToggleButton al pulsar "Comprobar":
//            binding.toggleSeleccion.isChecked = !binding.toggleSeleccion.isChecked
//        }
//    }

// **DESACTIVAR EL BOTÓN "COMPROBAR" SEGÚN EL ESTADO DE UN CHECKBOX**
// 1. Escuchar cambios en el CheckBox:
//    Añadir un listener en el CheckBox para que al cambiar su estado active o desactive el botón:
//    binding.checkActivar.setOnCheckedChangeListener { _, isChecked ->
//        // Habilitar o deshabilitar el botón "Comprobar" según el estado del CheckBox:
//        binding.btnComprobar.isEnabled = isChecked
//    }

// **RADIO GROUP: MANEJO DE BOTONES DE RADIO**
// 1. Obtener el botón seleccionado usando su identificador (ID):
//    val seleccionado: Int = binding.grupoRadios.checkedRadioButtonId
//    Usar un `when` para manejar acciones basadas en el botón seleccionado:
//    when (seleccionado) {
//        binding.idRadio1.id -> {
//            // Acción para el RadioButton 1.
//        }
//        binding.idRadio2.id -> {
//            // Acción para el RadioButton 2.
//        }
//    }

// 2. Obtener el texto del botón seleccionado:
//    val seleccionado: RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId)
//    Mostrar el texto del RadioButton seleccionado en un Snackbar:
//    Snackbar.make(
//        binding.root,
//        "El seleccionado es ${seleccionado.text}",
//        Snackbar.LENGTH_SHORT
//    ).show()

// **ESCUCHAR CAMBIOS EN EL RADIO GROUP**
// 1. Configurar un listener para el RadioGroup:
//    binding.grupoRadios.setOnCheckedChangeListener(this)

// 2. Implementar la interfaz `RadioGroup.OnCheckedChangeListener`:
//    Al implementar esta interfaz, MainActivity debe sobrescribir el método `onCheckedChanged`.

// 3. Sobrescribir el método de la interfaz:
//    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
//        // `checkedId` indica el ID del RadioButton seleccionado.
//        when (checkedId) {
//            binding.idRadio1.id -> {
//                // Acción para la selección del RadioButton 1.
//            }
//            binding.idRadio2.id -> {
//                // Acción para la selección del RadioButton 2.
//            }
//        }
//    }

// **IMPLEMENTACIÓN DE INTERFACES**
// MainActivity implementa las siguientes interfaces:
// 1. `OnClickListener`: Para manejar clics en botones.
// 2. `CompoundButton.OnCheckedChangeListener`: Para manejar cambios en componentes como ToggleButton o CheckBox.
// 3. `RadioGroup.OnCheckedChangeListener`: Para manejar cambios de selección en un grupo de RadioButtons.

// Estas interfaces centralizan el manejo de eventos en una sola clase, haciendo que el código sea más organizado y mantenible.

// **PASOS ADICIONALES PARA DISEÑO**
// 1. Descargar imágenes necesarias y copiarlas en la carpeta `drawable`.
// 2. Crear un archivo XML para personalizar el diseño del ToggleButton:
//    - Hacer clic derecho en la carpeta `drawable` -> New -> Drawable resource file.
//    - Asignar un nombre, por ejemplo, `background_toggle`.
//    - En el archivo XML, definir un diseño personalizado (por ejemplo, usar `<selector>` para cambiar colores según el estado del ToggleButton).

class MainActivity : AppCompatActivity(), View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    // Variable privada para usar View Binding. Esto ayuda a acceder a las vistas del layout sin usar findViewById repetidamente.
    private lateinit var binding: ActivityMainBinding

    // Método que se ejecuta al iniciar la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización de View Binding para vincular el archivo XML con la lógica del código.
        // El archivo `ActivityMainBinding` se genera automáticamente a partir de `activity_main.xml`.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Asignamos el layout inflado como la vista principal de la actividad.
        setContentView(binding.root)

        // Configuramos los listeners para los botones y otros componentes interactivos.

        // Este botón (btnComprobar) activará la lógica definida en el método `onClick`.
        binding.btnComprobar.setOnClickListener(this)

        // Este ToggleButton (toggleSelection) llamará al método `onCheckedChanged` cada vez que se cambie su estado (ON/OFF).
        binding.toggleSelection.setOnCheckedChangeListener(this)

        // Este CheckBox (checkActivar) también invocará `onCheckedChanged` para habilitar o deshabilitar el botón `btnComprobar`.
        binding.checkActivar.setOnCheckedChangeListener(this)

        binding.botonCambiar.setOnClickListener {
            // Inicia CochesActivity
            val intent = Intent(this, CochesActivity::class.java)
            startActivity(intent)
        }
    }

    // Método que se ejecuta al hacer clic en un botón.
    override fun onClick(v: View?) {
        // Verificamos qué vista ha generado el evento clic.
        when (v?.id) {
            // Si el clic fue en el botón `btnComprobar`...
            binding.btnComprobar.id -> {
                // Alternamos el estado del ToggleButton (`true` a `false` o viceversa).
                binding.toggleSelection.isChecked = !binding.toggleSelection.isChecked

                // Obtenemos el botón de radio seleccionado dentro del grupo de botones de radio.
                val seleccionado: RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId)

                // Mostramos un mensaje (Snackbar) indicando cuál opción de radio está seleccionada.
                Snackbar.make(binding.root, "El seleccionado es ${seleccionado.text}", Snackbar.LENGTH_SHORT).show()

                // Alternativa: Podríamos usar un `when` para reaccionar según el ID del botón de radio seleccionado.
                /*
                val seleccionado: Int = binding.grupoRadios.checkedRadioButtonId
                when(seleccionado){
                    binding.idRadio1.id -> { // Lógica para el primer radio button. }
                    binding.idRadio2.id -> { // Lógica para el segundo radio button. }
                }
                */
                // Configura el OnClickListener para el botón "Cambiar ventana"

            }
        }
    }

    // Método que se ejecuta cuando cambia el estado de un CompoundButton (ToggleButton o CheckBox).
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        // Verificamos qué botón generó el cambio.
        when (buttonView?.id) {
            // Si fue el ToggleButton (toggleSelection)...
            binding.toggleSelection.id -> {
                // Actualizamos el texto del TextView (textoToggle) para reflejar el estado actual del ToggleButton.
                binding.textoToggle.text = isChecked.toString()
            }

            // Si fue el CheckBox (checkActivar)...
            binding.checkActivar.id -> {
                // Habilitamos o deshabilitamos el botón `btnComprobar` según el estado del CheckBox.
                binding.btnComprobar.isEnabled = isChecked
            }
        }
    }

    // Método que se ejecuta cuando cambia la selección en el grupo de botones de radio.
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        // Verificamos cuál botón de radio se seleccionó.
        when (checkedId) {
            // Si se selecciona el primer botón de radio...
            binding.idRadio1.id -> {
                // Aquí podemos definir la lógica que debe ejecutarse cuando este botón sea seleccionado.
            }

            // Si se selecciona el segundo botón de radio...
            binding.idRadio2.id -> {
                // Lógica para la segunda opción.
            }
        }
    }
}
