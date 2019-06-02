package com.example.basquetballparcial

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basquetballparcial.Adapter.AdapterPartido
import com.example.basquetballparcial.Entities.partido
import com.example.basquetballparcial.ViewModel.PartidoViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var partidoViewModel : PartidoViewModel
    private lateinit var adapterPartido : AdapterPartido

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)

        adapterPartido = AdapterPartido(emptyList(), {partido:partido -> (mostrarPartido(partido))})
        rv_partido.adapter = adapterPartido
        rv_partido.layoutManager = LinearLayoutManager(this)

        partidoViewModel.allPartido.observe(this, Observer {partido ->
            partido?.let{ adapterPartido.setPartido(it) }
        })

        fab.setOnClickListener { view ->
            var intent = Intent(this, PartidoActivity::class.java)
            startActivity(intent)
        }
    }

    fun mostrarPartido(partido: partido){

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
