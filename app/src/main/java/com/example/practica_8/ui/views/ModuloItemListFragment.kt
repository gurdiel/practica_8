package com.example.practica_8.ui.views

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.practica_8.databinding.FragmentModuloItemListBinding
import com.example.practica_8.ui.adapters.MyModuloItemListAdapter
import com.example.practica_8.ui.adapters.MyModuloItemRecyclerViewAdapter
import com.example.practica_8.ui.viewmodel.ModelVMFactory
import com.example.practica_8.ui.viewmodel.Modelo

/**
 * A fragment representing a list of Items.
 */
class ModuloItemListFragment : Fragment() {

    private var columnCount = 1
    private var _binding: FragmentModuloItemListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: Modelo by activityViewModels {
        ModelVMFactory()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentModuloItemListBinding.inflate(inflater,container,false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the adapter
        val view = binding.list
        val modulosAdapter = MyModuloItemListAdapter()
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = modulosAdapter
            }
        viewModel.allModulos.observe(viewLifecycleOwner){
            modulosAdapter.submitList(it){
                binding.list.scrollToPosition(0)
            }
        }
    }
}