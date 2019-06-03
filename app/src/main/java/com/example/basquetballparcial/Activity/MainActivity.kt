package com.example.basquetballparcial.Activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity;
import com.example.basquetballparcial.Database.Entities.partido
import com.example.basquetballparcial.R
import com.example.basquetballparcial.Fragment.fragment_info
import com.example.basquetballparcial.Fragment.fragment_principal

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), fragment_principal.OnListener {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab.setOnClickListener { view ->
            var intent = Intent(this, generalInfo::class.java)
            startActivity(intent)
        }

        if (secundario != null){
            supportFragmentManager.beginTransaction().replace(R.id.secundario, fragment_info()).commit()
        }
    }

    override fun mostrarPartido(partido: partido){
        if(secundario == null){
            var intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("Info", partido as Parcelable)
            startActivity(intent)
        } else{
            var instance = fragment_info.newInstance(partido)
            supportFragmentManager.beginTransaction().replace(R.id.secundario, instance).commit()
        }
    }
}
