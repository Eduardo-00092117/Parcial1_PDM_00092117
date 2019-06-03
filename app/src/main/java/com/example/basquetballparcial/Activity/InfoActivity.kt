package com.example.basquetballparcial.Activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basquetballparcial.R
import com.example.basquetballparcial.Fragment.fragment_info

class InfoActivity : AppCompatActivity(), fragment_info.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        var instance = fragment_info.newInstance(intent.getParcelableExtra("Info"))
        supportFragmentManager.beginTransaction().replace(R.id.secundario, instance).commit()
    }
}
