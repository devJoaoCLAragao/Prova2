package br.com.cotemig.joaocarlos.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInitializer  {
    private val retrofit = Retrofit.Builder().
    baseUrl("https://mockup.fluo.app/v1/").
    addConverterFactory(GsonConverterFactory.create()).
    build()

    fun serviceFatura() : ServiceFatura{
        return retrofit.create(ServiceFatura::class.java)
    }
}