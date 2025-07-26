package com.example.rehber.data.entity

import java.io.Serializable

data class Kisiler(var kisi_id: Int, var kisi_ad : String, var kisi_tel : String) : Serializable {
    // Veri tabanında veri işlemleri yapacaksak class'a data ekini eklemeliyiz.
    //Eğer nesne transferi yapmak istiyorsak Serializable interface'ini kullanmalıyız.


}