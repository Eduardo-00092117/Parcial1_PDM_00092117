package com.example.basquetballparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.basquetballparcial.Entities.partido
import com.example.basquetballparcial.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {

    private lateinit var partidoView : PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)
        partidoView = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        btn_Guardar.setOnClickListener {
            var equipoGanador = ""
            if (tv_cont_A.text.toString().toInt() >= tv_cont_B.text.toString().toInt()){
                equipoGanador = ed_equipo1.text.toString()
            } else if (tv_cont_A.text.toString().toInt() <= tv_cont_B.text.toString().toInt()){
                equipoGanador = ed_equipo2.text.toString()
            } else{
                equipoGanador = "Empatado"
            }
            partidoView.insert(partido(ed_equipo1.text.toString(), ed_equipo2.text.toString(), tv_cont_A.text.toString().toInt(), tv_cont_B.text.toString().toInt(), equipoGanador, et_fecha.text.toString(), et_hora.toString()))
            onBackPressed()
        }
        btn_cancelar.setOnClickListener {
            onBackPressed()
        }
    }
}
