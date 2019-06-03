package com.example.basquetballparcial.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.basquetballparcial.R
import kotlinx.android.synthetic.main.activity_general_info.*

class generalInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_info)

        btn_iniciar.setOnClickListener {
            if (!ed_equipo1.text.isEmpty() && !ed_equipo2.text.isEmpty() && !et_hora.text.isEmpty()){
                var intent = Intent(this, PartidoActivity::class.java)
                intent.putExtra("equipo1", ed_equipo1.text.toString())
                intent.putExtra("equipo2", ed_equipo2.text.toString())
                var fecha = et_fecha.dayOfMonth.toString() + "/" + et_fecha.month.toString() + "/" + et_fecha.year.toString()
                intent.putExtra("fecha", fecha)
                intent.putExtra("hora", et_hora.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "Debe llenar todos los campos!", Toast.LENGTH_LONG).show()
            }
        }

        btn_cancelar.setOnClickListener {
            onBackPressed()
        }
    }
}
