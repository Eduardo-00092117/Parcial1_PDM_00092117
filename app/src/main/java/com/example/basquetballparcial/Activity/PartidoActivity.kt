package com.example.basquetballparcial.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.basquetballparcial.Database.Entities.partido
import com.example.basquetballparcial.R
import com.example.basquetballparcial.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.activity_partido.*

class PartidoActivity : AppCompatActivity() {

    private lateinit var partidoView : PartidoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_partido)

        partidoView = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        tv_cont_A.text = partidoView.puntuacionA.toString()
        tv_cont_B.text = partidoView.puntuacionB.toString()

        tv_equipo1.text = intent.getStringExtra("equipo1")
        tv_equipo2.text = intent.getStringExtra("equipo2")
        tv_fecha.text = "Fecha: " + intent.getStringExtra("fecha")
        tv_hora.text = "Hora: " + intent.getStringExtra("hora")

        btn_Guardar.setOnClickListener {
            var equipoGanador = ""
            if (tv_cont_A.text.toString().toInt() > tv_cont_B.text.toString().toInt()){
                equipoGanador = tv_equipo1.text.toString()
            } else if (tv_cont_A.text.toString().toInt() < tv_cont_B.text.toString().toInt()){
                equipoGanador = tv_equipo2.text.toString()
            } else{
                equipoGanador = "Empate"
            }
            partidoView.insert(partido(tv_equipo1.text.toString(), tv_equipo2.text.toString(), tv_cont_A.text.toString().toInt(), tv_cont_B.text.toString().toInt(), equipoGanador, intent.getStringExtra("fecha"), intent.getStringExtra("hora")))
            Toast.makeText(this, "Partido guardado!!", Toast.LENGTH_LONG).show()
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
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
