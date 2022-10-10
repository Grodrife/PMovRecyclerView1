package com.boletin.rv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.boletin.rv.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_CONTACTO = "DetailActivity:Contacto"
    }

    private lateinit var botonLlamada: Button
    private lateinit var botonEmail: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contacto = intent?.getParcelableExtra<Contacto>(EXTRA_CONTACTO) ?: throw IllegalStateException()

        binding.btnllamar.setOnClickListener{
            val intentLlamada = Intent(Intent.ACTION_DIAL)
            intentLlamada.data = Uri.parse("tel:${contacto.phonenumber.toString()}")
            startActivity(intentLlamada)
        }

        binding.btnEmail.setOnClickListener{
            val intentEmail = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${contacto.email}")
            }
            startActivity(intentEmail)
        }

        supportActionBar?.title = contacto.name

        binding.name.text = contacto.name

        Glide.with(binding.imageView)
            .load(contacto.imagen)
            .into(binding.imageView)
    }
}