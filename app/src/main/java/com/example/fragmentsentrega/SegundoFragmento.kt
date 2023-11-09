package com.example.fragmentsentrega

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SegundoFragmento : Fragment() {

    private lateinit var textView: TextView
    private lateinit var botonVolver: Button
    private lateinit var viewModel: SharedViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView = view.findViewById(R.id.textView)
        botonVolver = view.findViewById(R.id.botonVolver)

        // Obtiene una referencia al ViewModel compartido
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // Observa el LiveData y actualiza el textView cuando cambia
        viewModel.textoLiveData.observe(viewLifecycleOwner, Observer {
            textView.text = "Hola $it" //Para que el texto del EditText del fragment 1 se concatene a la palabra hola
        })

        // Configurar el OnClickListener para el botón
        botonVolver.setOnClickListener {
            // Volver al Fragmento1
            requireActivity().supportFragmentManager.popBackStack()
        }

        return view
    }

    fun onTextoEnviado(texto: String) {
        // No necesitamos hacer nada aquí, ya que el texto se actualiza a través del LiveData
    }
}
