package com.example.practica_8.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.practica_8.data.database.Modulos
import com.example.practica_8.databinding.FragmentModuloItemBinding
import java.text.SimpleDateFormat
import java.util.Date

class MyModuloItemListAdapter() : ListAdapter<Modulos,MyModuloItemListAdapter.ViewHolder>(
    DiffUtilModulos) {

    private companion object{
        private val DiffUtilModulos = object: DiffUtil.ItemCallback<Modulos>(){
            override fun areItemsTheSame(oldItem: Modulos, newItem: Modulos): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Modulos, newItem: Modulos): Boolean {
                return oldItem == newItem
            }
        }
    }
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
        holder.binData(getItem(position))
    }
    inner class ViewHolder(val binding: FragmentModuloItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binData(item: Modulos){
            binding.idHeaderItem.text = item.id.toString()
            binding.moduloItem.text = item.modulo
            binding.creditosItem.text = item.creditos
            binding.fechaItem.text = SimpleDateFormat("dd/MM/yyyy h:mm a").format(Date(item.timestamp))
        }
    }
}