package br.com.cotemig.joaocarlos.services

import br.com.cotemig.joaocarlos.model.Despesa
import br.com.cotemig.joaocarlos.model.Fatura
import retrofit2.Call
import retrofit2.http.GET

interface ServiceFatura {

    @GET("fatura")
    fun getFatura() : Call<Fatura>
}