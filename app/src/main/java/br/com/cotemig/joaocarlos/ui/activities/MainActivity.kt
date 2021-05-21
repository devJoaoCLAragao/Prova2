package br.com.cotemig.joaocarlos.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.joaocarlos.R
import br.com.cotemig.joaocarlos.model.Despesa
import br.com.cotemig.joaocarlos.model.Fatura
import br.com.cotemig.joaocarlos.services.RetrofitInitializer
import br.com.cotemig.joaocarlos.ui.adapters.FaturaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getFatura()
    }

    fun getFatura(){
        var s = RetrofitInitializer().serviceFatura()
        var call = s.getFatura()

        call.enqueue(object : retrofit2.Callback<Fatura>{
            override fun onFailure(call: Call<Fatura>, t: Throwable) {
                Toast.makeText(this@MainActivity,"DEU RUIM, CORRE", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Fatura>, response: Response<Fatura>) {
                if (response.code() == 200){
                    response.body()?.let {
                        showFatura(it.despesas)
                        valor.text = String.format("R$ %.2f",it.valor.toString().toDouble())
                        limiteDisponivel.text = String.format("Disponivel R$ %.2f",it.limiteDisponivel.toString().toDouble())
                    }
                }
            }
        })
    }

    fun showFatura(list: List<Despesa>){
        recyclerViewDespesa.adapter = FaturaAdapter(this, list)
        recyclerViewDespesa.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}