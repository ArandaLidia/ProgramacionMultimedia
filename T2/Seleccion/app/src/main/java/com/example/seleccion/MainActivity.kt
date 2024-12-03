package com.example.seleccion

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

////PRIMERO : EN BUILD.GRADLE.KTS viewBinding { enable = true } y sincronizar
////SEGUNDO: CREAR VARIABLE EN MAINACTIVITY: private lateinit var: activity var binding: ActivityMainBinding
////TERCERO: inicializar variable despues super.onCreate -> binding = ActivityMainBinding.inflate(layoutInflater)



//CAMBIAR EL ESTADO AL PULSAR BOTON COMPROBAR, O CAMBIAR RESULTADO AL PULSAR EL BOTON TOGGLER PARA ACTIVAR O DESACTIVAR.
//AL BOTON COMPROBAR
//1º binding.btnComprobar.setOnclikListener(this)
//2º EN override fun onClic(p0: View?){

//when(p0.id) {
//binding.btnComprobar.id ->{  --El boton que se ha pulsado, el identificador ha sido btnComprobar?  -> introducir metodo.
//Sacar el estado de un elemento con snackbar: Devuelve true o false
//Snackbar.make(binding.root, "El estado del toggle es ${binding.toggleSeleccion.isChecked}", Snackbar.LENGTH_SHORT).show

//PARA QUE CAMBIE AL PULSAR EN EL TOGGLE
//1º binding.toggleSeleccion.setOnCheckedChangeListener(Listener: CompoundButton.Oncheck......)
//binding.toggleSelecction.setOnCheckedChangeListener(this)
//2º implementarlo en class MainActivity
//OnCheckedChangeListener (CompoundButton) CompoundButton porque tiene dos estados true o false
//3ºImplementar metodo
//4º override fun onCheckedChanged(p0: CompounButton?, p1:Boolean){   p1 : Boolean = Si es false o true
//      when(p0?.id){  -  -> Si el id p= es el que proboca el cambio
//  binding.toggleSeleccion.id ->{  ->id toogleSeleccion es el toogle. cuando va cambiando true o false
//          binding.textoToggle.text = p1.toString()   ->  en el textview (textotoogle) Pone true o false dependiendo si el toogle esta activado o no.
//        }
// }
//5º en onClick
// binding.btnComprobar.id ->{
//                binding.toggleSelection.isChecked =! binding.toggleSelection.isChecked   -> Cada vez que pulsamos boton comprobar, aparece la otra opcion.
//            }
//EL CHECKED, CUANDO ESTÁ ACTIVADO DESACTIVAR EL BOTON
// binding.checkActivar.id ->{
//                binding.btnComprobar.isEnabled = isChecked; //Al pulsar el cheked y desactivarlo, se desactiva el boton comprobar
//            }

//RADIO GROUP
//OPCION 1 -> Preguntar por el identificador
// val seleccionado: Int = binding.grupoRadios.checkedRadioButtonId   -> Devuelve el id del radioButton seleccionado
//                when(seleccionado){   -> switch
//                    binding.idRadio1.id -> {}
//                    binding.idRadio2.id -> {}
//                }

//OPCION 2: TEXTO DEL QUE ESTÁ SELECCIONADO
// val seleccionado: RadioButton = binding.grupoRadios.checkedRadioButtonId
//val seleccionado : RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId); //Me das un id y te devuelvo una vista.
//                Snackbar.make(binding.root, "El seleccionado es ${seleccionado.text}", Snackbar.LENGTH_SHORT).show()
//Devuelve un Snackbar diciendo que radiobutton es el seleccionado con el FINDVIEWBYID
//Sacar la vista es sacar el elemento, el radio seleccionado, etc

//PARA PONER A ESCUCHAR EL RADIO GROUP, IMPLEMENTAMOS -> OnCheckedChangeListener (radio.group) e implementamos members

// Clase principal de la actividad que extiende AppCompatActivity
// Implementa las interfaces OnClickListener y OnCheckedChangeListener para manejar eventos de clic y cambios de estado.
//En el metodo se puede implementar que si se selecciona una opcion se habiliten cosas y si se selecciona otra, se habiliten otras.
//override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
//        when(checkedId){
//            binding.idRadio1.id ->{
//
//            }
//            binding.idRadio2.id->{
//
//            }
//        }
//    }

//DESCARGAR BOTONES y ponerlos en androidstudio.
//Descargar imagenes y ponerlos en drawable, pegar
//new drawable resource file : nombre: background_toggle
//Sale el xml
class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    // Variable privada para el enlace de vistas usando View Binding.
    private lateinit var binding: ActivityMainBinding

    // Método llamado al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa el binding para la actividad, vinculando la interfaz de usuario.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Establece la vista de la actividad al layout inflado.
        setContentView(binding.root)

        // Asocia el listener de clics al botón btnComprobar.
        binding.btnComprobar.setOnClickListener(this)
        // Asocia el listener de cambios de estado al ToggleButton toggleSelection.
        binding.toggleSelection.setOnCheckedChangeListener(this)
        binding.checkActivar.setOnCheckedChangeListener(this) //Usa el mismo metodo setOnCheckedChangeListener
    }

    // Método que se ejecuta cuando se hace clic en un elemento de la vista.
    override fun onClick(v: View?) {
        // Verifica si el elemento que se ha clicado es el botón btnComprobar.
        when (v?.id) {
            binding.btnComprobar.id ->{
                binding.toggleSelection.isChecked =! binding.toggleSelection.isChecked

                val seleccionado : RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId); //Me das un id y te devuelvo una vista.
                Snackbar.make(binding.root, "El seleccionado es ${seleccionado.text}", Snackbar.LENGTH_SHORT).show()
                /*val seleccionado: Int = binding.grupoRadios.checkedRadioButtonId
                when(seleccionado){
                    binding.idRadio1.id -> {}
                    binding.idRadio2.id -> {}
                }*/
            }


        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.toggleSelection.id -> {
                // Actualiza el texto del TextView textoToggle con el estado del ToggleButton (true o false).
                binding.textoToggle.text = isChecked.toString()
            }
            binding.checkActivar.id ->{
                binding.btnComprobar.isEnabled = isChecked; //Al pulsar el cheked y desactivarlo, se desactiva el boton comprobar
            }
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when(checkedId){
            binding.idRadio1.id ->{

            }
            binding.idRadio2.id->{

            }
        }
    }
}


