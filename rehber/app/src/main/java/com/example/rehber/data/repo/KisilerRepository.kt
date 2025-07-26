package com.example.rehber.data.repo

import android.util.Log
import com.example.rehber.data.entity.Kisiler
import com.example.rehber.data.source.KisilerDataSource

class KisilerRepository {       //reponun görevi gelenleri datasource a iletmektir.

    var kisilerDataSoruce = KisilerDataSource()

    suspend fun kaydet(kisi_ad: String,kisi_tel:String) = kisilerDataSoruce.kaydet(kisi_ad,kisi_tel)
    // Repository deki kaydet fonku çalışırsa dataSource daki kaydet fonkunu çalıştırır.

    suspend fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel : String) = kisilerDataSoruce.guncelle(kisi_id,kisi_ad,kisi_tel)

    suspend fun silme(kisi_id : Int) = kisilerDataSoruce.silme(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kisilerDataSoruce.kisileriYukle()

    suspend fun ara(aramaKelimesi : String) : List<Kisiler> = kisilerDataSoruce.ara(aramaKelimesi)

}