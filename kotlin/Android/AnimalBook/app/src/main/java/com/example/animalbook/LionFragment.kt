package com.example.animalbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animalbook.databinding.FragmentLionBinding

/**
 * A simple [Fragment] subclass.
 */
class LionFragment : Fragment() {
    private var _binding: FragmentLionBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}
