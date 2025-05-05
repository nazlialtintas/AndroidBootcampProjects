package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentAnasayfaBinding

class Anasayfa : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(layoutInflater,container,false)

        binding.fragmentMaintoA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_anasayfa_to_sayfa_A)
        }

        binding.fragmentMaintoX.setOnClickListener { it->
            Navigation.findNavController(it).navigate(R.id.action_anasayfa_to_sayfa_X)
        }
        return binding.root
    }
}