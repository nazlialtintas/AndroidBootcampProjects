package com.example.rehber.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.rehber.data.entity.Kisiler
import com.example.rehber.databinding.CardTasarimBinding
import com.example.rehber.databinding.FragmentAnasayfaBinding
import com.example.rehber.ui.fragment.AnasayfaFragmentDirections
import com.example.rehber.ui.viewmodel.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar
//                  aContext :: Şuanda hangi cardda olduğumuzu belirtir.
class KisilerAdapter(var aContext: Context, var kisilerListesi: List<Kisiler>, var viewModel: AnasayfaViewModel) : RecyclerView.Adapter<KisilerAdapter.CardTasarimHolder>(){       // Context :Hangi sayfada olduğumuzu belirttiğimiz bir nesne Sınıf tanımlamalarını yaptık sonra adapter olan kısmı ekledik
        // Sınıfımızı oluşturduk fakat şimdi bunu card tasarima bağlamak için bir inner class oluşturacağız.
    inner class CardTasarimHolder( var tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)         // Card tasarimlarını koda bağlayacaksak bu şkelide yapılır.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(aContext),parent,false)
        return  CardTasarimHolder(tasarim)
    }

    override fun getItemCount(): Int {      // Kaç tane kart üretelecekse üretir
        return kisilerListesi.size
    }


    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val kisi = kisilerListesi.get(position)  // Positiona göre nesneleri kişiye atayacak
        val t = holder.tasarim      // tasarıma erişmek için oluşturuldu
        t.kisiAd.text= kisi.kisi_ad
        t.kisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.silme(kisi.kisi_id)
                }.show()
        }
    }

}