package com.example.rehber.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rehber.data.entity.Kisiler
import com.example.rehber.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {     // ViewModel() -> Kalıtım parantez olmazsa interface
    var kisilerRepository= KisilerRepository()
    val kisilerListesi = MutableLiveData<List<Kisiler>>()

    fun silme(kisi_id : Int){
       CoroutineScope(Dispatchers.Main).launch {
           kisilerRepository.silme(kisi_id)
           kisileriYukle()
       }
    }
    // view modelden nesne oluşturduğumuzu nasıl anlarız? - İnit methoduyla
    init {      // constructor dediğimiz kavram
        kisileriYukle()
    }

    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.kisileriYukle()    // Tetikleme
        }
    }

    fun ara(aramaKelimesi : String){
        CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kisilerRepository.ara(aramaKelimesi)     // Burada da tetikleme var
        }
    }
}