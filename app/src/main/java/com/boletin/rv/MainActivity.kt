package com.boletin.rv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boletin.rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            recycler.adapter = ContactosAdapter(contactos) { contacto ->

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_CONTACTO, contacto)
                startActivity(intent)
            }
        }

    }
}

private val contactos = (1..100).map {
    Contacto(
        "https://loremflickr.com/240/320/profilepic?lock=$it",
        "Nombre $it",
        "Telefono $it",
        "Email $it"
    )
}
