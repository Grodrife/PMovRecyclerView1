package com.boletin.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.boletin.rv.databinding.ViewContactoItemBinding
import com.bumptech.glide.Glide

class ContactosAdapter(val list: List<Contacto>, val listener: (Contacto) -> Unit): RecyclerView.Adapter<ContactosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_contacto_item, parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = ViewContactoItemBinding.bind(view)

        fun bind(contacto: Contacto){
            Glide.with(binding.imageView)
                .load(contacto.imagen)
                .into(binding.imageView)

            binding.tvNombre.text = contacto.name
            binding.tvNumber.text = contacto.phonenumber
            binding.tvEmail.text = contacto.email
        }

    }


}