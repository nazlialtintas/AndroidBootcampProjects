package com.example.rehber.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.rehber.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiKayitViewModel : ViewModel() {
    var kisilerRepository= KisilerRepository()

    fun kaydet(kisi_ad: String,kisi_tel:String){        //suspend eki fonksiyonun coroutine çalışmasını sağlar. suspend fun yazabilirdik ama bu fonk arayüzle bağlantılı olacağı için biz bunu istemiyoruz. So aşağıdakini kullanılır.
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.kaydet(kisi_ad,kisi_tel)
        }  // Main -> Daha çok arayüze yakın olan kısımlarda kullanılır. IO-> Veritabanına yakın olduğumuz yerlerde kullanılır.
    }
}