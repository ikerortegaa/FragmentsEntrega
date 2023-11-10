package com.example.fragmentsentrega
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var primerFragmento: PrimerFragmento
    private lateinit var segundoFragmento: SegundoFragmento
    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        primerFragmento = PrimerFragmento()
        segundoFragmento = SegundoFragmento()
        viewModel = ViewModelProvider(this)[SharedViewModel::class.java]

        // Inicia el PrimerFragmento
        supportFragmentManager.beginTransaction()
            .replace(R.id.contenedorFragment, primerFragmento)
            .commit()

        // Observa el LiveData en el ViewModel y actualiza el segundo fragmento cuando cambia
        viewModel.textoLiveData.observe(this, Observer {
            segundoFragmento.onTextoEnviado(it)
            supportFragmentManager.beginTransaction()
                .replace(R.id.contenedorFragment, segundoFragmento)
                .addToBackStack(null)
                .commit()
        })
    }
}
