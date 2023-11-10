package com.example.fragmentsentrega;
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PrimerFragmento : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_primero, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val editText = view.findViewById<EditText>(R.id.editText)
        val enviarButton = view.findViewById<Button>(R.id.enviarButton)

        enviarButton.setOnClickListener {
            val texto = editText.text.toString()
            // Actualiza el LiveData en el ViewModel
            viewModel.textoLiveData.value = texto
        }

        return view
    }
}
