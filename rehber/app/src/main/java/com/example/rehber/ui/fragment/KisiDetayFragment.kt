package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.rehber.R
import com.example.rehber.databinding.FragmentKisiDetayBinding
import com.example.rehber.ui.viewmodel.KisiDetayviewModel
import com.example.rehber.ui.viewmodel.KisiKayitViewModel


class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayviewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentKisiDetayBinding.inflate(inflater,container,false)

        val bundle : KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        binding.editTextKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        binding.buttonGuncelle.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            viewModel.guncelle(gelenKisi.kisi_id,kisi_ad,kisi_tel)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiDetayviewModel by viewModels()       // Önemli
        viewModel = tempViewModel
    }


}