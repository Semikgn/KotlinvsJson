package com.example.kullaniciapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kullaniciapp.model.User
import com.example.kullaniciapp.service.UserAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailViewModel: ViewModel() {
    //copy paste yaptık, normalde DI ile almak daha sağlıklı
    private val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    suspend fun getSingleUser(id : Int) : User {

        val user = retrofit.getSingleUser().get(id)
        return user
    }
}