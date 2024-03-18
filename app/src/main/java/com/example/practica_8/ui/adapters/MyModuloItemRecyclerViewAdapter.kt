package com.example.practica_8.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.practica_8.data.database.Modulos
import com.example.practica_8.databinding.FragmentModuloItemBinding
import java.text.SimpleDateFormat
import java.util.Date

class MyModuloItemRecyclerViewAdapter(private var values: List<Modulos>) : RecyclerView.Adapter<MyModuloItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentModuloItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.binData(item)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: FragmentModuloItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(item: Modulos){
            binding.idHeaderItem.text = item.id.toString()
            binding.moduloItem.text = item.modulo
            binding.creditosItem.text = item.creditos
            binding.fechaItem.text = SimpleDateFormat("dd/MM/yyyy h:mm a").format(Date(item.timestamp))
        }
    }

    fun updateList(newList: List<Modulos>){
        values = newList
        notifyDataSetChanged() // Dice que no es muy eficiente pero lo vamos a cambiar.
    }

}