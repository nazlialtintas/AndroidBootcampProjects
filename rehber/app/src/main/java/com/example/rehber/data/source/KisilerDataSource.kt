package com.example.rehber.data.source

import android.util.Log
import com.example.rehber.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {           // Kullanmak istediğimiz fonksiyonları buraya yazdık ardından bunları repositorye ekledik. Sonra o fonkları nerede kullancaksak oranın viewmodeline ekliyoruz.
    suspend fun kaydet(kisi_ad: String,kisi_tel:String){        //suspend eki fonksiyonun coroutine çalışmasını sağlar. Coroutine: Aynı anda birden fazla işlem yapılmasını sağlar
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")

    }

    suspend fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel : String) {      // Aynı zamanda suspend i veritabanıyla ilgili işlem yapmak istediğmiz için ekliyoruz.
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun silme(kisi_id : Int){
        Log.e("KişiSil", kisi_id.toString())
    }

    suspend fun kisileriYukle() : List<Kisiler> = withContext(Dispatchers.IO){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Nazlı", "1111")
        val k2 = Kisiler(2,"Berk","2222")
        val k3 = Kisiler(3,"Emir","3333")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)

        return@withContext liste
    }

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = withContext(Dispatchers.IO){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Nazlı", "1111")
        liste.add(k1)

        return@withContext liste
    }
}