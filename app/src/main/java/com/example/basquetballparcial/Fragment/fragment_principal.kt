package com.example.basquetballparcial.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basquetballparcial.Adapter.AdapterPartido
import com.example.basquetballparcial.Database.Entities.partido
import com.example.basquetballparcial.R
import com.example.basquetballparcial.ViewModel.PartidoViewModel
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_fragment_principal.view.*


class fragment_principal : Fragment() {
    private var listener: OnListener? = null
    private lateinit var partidoViewModel : PartidoViewModel
    private lateinit var adapterPartido : AdapterPartido

    interface OnListener {
        fun mostrarPartido(partido: partido)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_fragment_principal, container, false)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        adapterPartido = AdapterPartido(emptyList(), {partido: partido -> (listener?.mostrarPartido(partido))})
        view.rv_partido.adapter = adapterPartido
        view.rv_partido.layoutManager = LinearLayoutManager(context)

        partidoViewModel.allPartido.observe(this, Observer {partido ->
            partido?.let{ adapterPartido.setPartido(it) }
        })

        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
