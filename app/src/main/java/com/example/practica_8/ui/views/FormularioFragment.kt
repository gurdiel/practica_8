package com.example.practica_8.ui.views

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            guardado()
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
    private fun guardado(){

        val txtNombre = binding.etModulo
        val creditos = binding.etCreditos

        if(txtNombre == null || txtNombre.text.toString().trim().length == 0){
            //No dejo meter espacios en blanco
            Toast.makeText(context,"Introduce un nombre correcto", Toast.LENGTH_SHORT).show()
            txtNombre.setText("")
            return
        }
        if(creditos == null || creditos.text.toString() == ""){
            Toast.makeText(context,"Introduce un número correcto", Toast.LENGTH_SHORT).show()
            return
        }
        sharedVM.guardar(txtNombre.text.toString(),creditos.text.toString())
        txtNombre.setText("")
        creditos.setText("")
        txtNombre.requestFocus()
    }



}