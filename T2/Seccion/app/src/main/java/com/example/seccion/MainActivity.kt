// Importación de las bibliotecas necesarias para la aplicación.
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seccion.databinding.ActivityMainBinding
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



// Clase principal de la actividad que extiende AppCompatActivity
// Implementa las interfaces OnClickListener y OnCheckedChangeListener para manejar eventos de clic y cambios de estado.
class MainActivity : AppCompatActivity(), OnClickListener, OnCheckedChangeListener {
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
    }

    // Método que se ejecuta cuando se hace clic en un elemento de la vista.
    override fun onClick(v: View?) {
        // Verifica si el elemento que se ha clicado es el botón btnComprobar.
        when (v?.id) {

            }
        }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            binding.toggleSelection.id -> {
                // Actualiza el texto del TextView textoToggle con el estado del ToggleButton (true o false).
                binding.textoToggle.text = isChecked.toString()
            }
        }
    }
}


