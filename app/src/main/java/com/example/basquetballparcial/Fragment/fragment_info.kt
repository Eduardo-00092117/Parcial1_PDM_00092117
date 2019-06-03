package com.example.basquetballparcial.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.basquetballparcial.Database.Entities.partido
import com.example.basquetballparcial.R
import kotlinx.android.synthetic.main.fragment_fragment_info.view.*

class fragment_info : Fragment() {
    var partido : partido? = null

    companion object {
        @JvmStatic
        fun newInstance(Partido: partido) : fragment_info {
            var instance = fragment_info()
            instance.partido = Partido
            return instance
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_fragment_info, container, false)

        if (partido != null){
            view.tv_info_equipos.text = partido?.equipo1 + " vs " + partido?.equipo2
            view.tv_info_puntuacion.text = "(" + partido?.puntuacion1.toString() + " - " + partido?.puntuacion2.toString() + ")"
            view.tv_info_fecha.text = "Fecha : " + partido?.fecha
            view.tv_info_hora.text = "Hora : " + partido?.hora
            view.tv_info_ganador.text = "Ganador : " + partido?.ganador
        }
        return view
    }
}
