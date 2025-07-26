package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rehber.R
import com.example.rehber.data.entity.Kisiler
import com.example.rehber.databinding.FragmentAnasayfaBinding
import com.example.rehber.ui.adapter.KisilerAdapter
import com.example.rehber.ui.viewmodel.AnasayfaViewModel
import com.example.rehber.ui.viewmodel.KisiDetayviewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

         binding.fab.setOnClickListener {
             Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
         }

         viewModel.kisilerListesi.observe(viewLifecycleOwner){      // Dinleme
             val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)       //Burada görüntülenecek verileri anasayfaya eklemiş olduğumuz recyclerView'a bağlamış oluruz.
             binding.kisilerRecyclerView.adapter = kisilerAdapter
         }

         binding.kisilerRecyclerView.layoutManager = LinearLayoutManager(requireContext())      // Hangi tarzda görüntülenmesini istiyorsak burada belirtiyoruz

//         binding.kisilerRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)     // Bu da farklı bir görüntüleme şeklidir.
//         binding.kisilerRecyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {  // Harf girdikçe ve sildikçe çalışır
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {  // Ara butonuna basılınca çalışıor
                viewModel.ara(query)
                return true
            }
        })

         return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {       // Anasayfaya her girildiğinde geri dönüldüğünde bu fonk çalışır.
        super.onResume()
        viewModel.kisileriYukle()
    }
}