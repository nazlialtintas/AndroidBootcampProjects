package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentSayfaBBinding


class Sayfa_B : Fragment() {
    private lateinit var binding:FragmentSayfaBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSayfaBBinding.inflate(inflater,container,false)

        binding.fragmentBtoY.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_sayfa_B_to_sayfa_Y)
        }
        return binding.root
    }
}