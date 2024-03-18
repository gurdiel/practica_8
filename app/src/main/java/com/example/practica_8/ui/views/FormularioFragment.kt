package com.example.practica_8.ui.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.practica_8.R
import com.example.practica_8.databinding.FragmentFormularioBinding
import com.example.practica_8.ui.viewmodel.ModelVMFactory
import com.example.practica_8.ui.viewmodel.Modelo

class FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!

    private val sharedVM: Modelo by activityViewModels(){
        ModelVMFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFormularioBinding.inflate(inflater,container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         // Como extraigo números.

        binding.btnGuardar.setOnClickListener {

            val txtNombre: String = binding.etModulo.text.toString()
            val creditos:String = binding.etCreditos.text.toString()
            sharedVM.guardar(txtNombre,creditos)
            binding.etCreditos.setText(" ")
            binding.etModulo.setText(" ")
            binding.etModulo.requestFocus()

        }
        binding.btnEliminar.setOnClickListener{
            AlertDialog.Builder(context)
                .setTitle(getString(R.string.limpiar_title))
                .setMessage(getString(R.string.dialogo))
                .setNegativeButton(getString(R.string.cancel)){
                    dialog, id -> dialog.cancel()
                }
                .setPositiveButton(getString(R.string.confirmar)){
                    _, _ -> sharedVM.clearModulos()
                }
                .show()
        }
    }



}