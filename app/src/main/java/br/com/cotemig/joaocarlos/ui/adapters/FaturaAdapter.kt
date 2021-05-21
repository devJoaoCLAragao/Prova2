package br.com.cotemig.joaocarlos.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.joaocarlos.R
import br.com.cotemig.joaocarlos.model.Despesa
import coil.load

class FaturaAdapter (var context: Context, var list: List<Despesa>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_fatura, parent, false)
        return FaturaHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FaturaHolder).bind(context, list[position])
    }

    class FaturaHolder(var view : View) : RecyclerView.ViewHolder(view){
        fun bind(context: Context, despesa: Despesa){

            var imagem = view.findViewById<ImageView>(R.id.imagem)
            imagem.load(despesa.imagem)

            var descricao = view.findViewById<TextView>(R.id.descricao)
            descricao.text = despesa.descricao

            var tipo = view.findViewById<TextView>(R.id.tipo)
            tipo.text = despesa.tipo

            var valor = view.findViewById<TextView>(R.id.valor)
            valor.text = String.format("R$ %.2f",despesa.valor.toString().toDouble())

            var data = view.findViewById<TextView>(R.id.data)
            data.text = despesa.data
        }
    }


}