package com.example.fragmentsentrega

//He tenido que añadir esta clase para poder almacenar el texro del primer fragment ya que si no me daba un error en el LogCat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // Almaceno el texto a mostrar en el segundo fragment
    val textoLiveData = MutableLiveData<String>()
}
