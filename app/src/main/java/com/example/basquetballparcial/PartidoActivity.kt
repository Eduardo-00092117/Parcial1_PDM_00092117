package com.example.basquetballparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.basquetballparcial.Entities.partido
import com.example.basquetballparcial.ViewModel.PartidoViewModel
import com.example.basquetballparcial.ViewModel.PuntuacionesViewModel
import kotlinx.android.synthetic.main.activity_partido.*
import org.w3c.dom.Text

class PartidoActivity : AppCompatActivity() {

    private lateinit var partidoView : PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        partidoView = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        tv_cont_A.text = partidoView.puntuacionA.toString()
        tv_cont_B.text = partidoView.puntuacionB.toString()

        btn_Guardar.setOnClickListener {
            var equipoGanador = ""
            if (tv_cont_A.text.toString().toInt() > tv_cont_B.text.toString().toInt()){
                equipoGanador = ed_equipo1.text.toString()
            } else if (tv_cont_A.text.toString().toInt() < tv_cont_B.text.toString().toInt()){
                equipoGanador = ed_equipo2.text.toString()
            } else{
                equipoGanador = "Empate"
            }
            partidoView.insert(partido(ed_equipo1.text.toString(), ed_equipo2.text.toString(), tv_cont_A.text.toString().toInt(), tv_cont_B.text.toString().toInt(), equipoGanador, et_fecha.text.toString(), et_hora.text.toString()))
            Toast.makeText(this, "Partido guardado!!", Toast.LENGTH_LONG).show()
            onBackPressed()
        }
        btn_cancelar.setOnClickListener {
            onBackPressed()
        }
    }

    fun functionButton(v : View){
        when(v){
            btn_1punto_A ->{
                partidoView.puntuacionA += 1
            }
            btn_2puntos_A->{
                partidoView.puntuacionA += 2
            }
            btn_3puntos_A->{
                partidoView.puntuacionA += 3
            }
            btn_1punto_B ->{
                partidoView.puntuacionB += 1
            }
            btn_2puntos_B->{
                partidoView.puntuacionB += 2
            }
            btn_3puntos_B->{
                partidoView.puntuacionB += 3
            }
        }
        tv_cont_A.text = partidoView.puntuacionA.toString()
        tv_cont_B.text = partidoView.puntuacionB.toString()
    }
}
