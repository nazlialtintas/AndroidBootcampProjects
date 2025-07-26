package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rehber.R
import com.example.rehber.databinding.FragmentKisiKayitBinding
import com.example.rehber.ui.viewmodel.KisiKayitViewModel

class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel      //Önemli ViewModel bir yaşam döngüsü olması için onCreuate fonku içerisinde yapıyoruz.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKisiKayitBinding.inflate(inflater,container,false)


        binding.buttonKaydet.setOnClickListener {
            val kisi_ad= binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            viewModel.kaydet(kisi_ad,kisi_tel)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {        // Yaşam döngüsü fonku
        super.onCreate(savedInstanceState)
        val tempViewModel: KisiKayitViewModel by viewModels()       // Önemli --> ':' bu işaret özellik atamadır. '=' bu ise değer atamadır burada değer ataması yapmadığımız için temp oluşrutduk.
        viewModel = tempViewModel

    }


}