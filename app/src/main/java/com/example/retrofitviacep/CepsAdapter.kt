package com.example.retrofitviacep

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Ceps Adapter ele liga os dados com o layout
//Context é queme esta chamando a classe CepsAdapter
class CepsAdapter(var context: Context):RecyclerView.Adapter<CepsAdapter.CepViewHolder>(){

    private var listaCep = emptyList<Cep>()

    //Lista que sera montada no recycle
    fun updateListaCeps(lista: List<Cep>){
        listaCep = lista
        notifyDataSetChanged()
    }

    //Esse cara cria uma view, e é inflada pelo nosso layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CepViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ceps_recycler_view_layout, parent, false)

        return CepViewHolder(view)
    }

    //holder é a classe CepViewHolder, que é o card no xml
    override fun onBindViewHolder(holder: CepViewHolder, position: Int) {
        //pega o index|indice de qual posição eu estou
        Log.i("xptoholder", "onBindViewHolder")
        val cep = listaCep[position]

        holder.tvCep.text = cep.cep
        holder.tvLogradouro.text = cep.logradouro
        holder.tvLocalidade.text = cep.cidade
    }

    override fun getItemCount(): Int {
        Log.i("xptoholder", "getItemCount")
        return  listaCep.size
    }

    //Inner Class um loop de criação de componentes => ItemView que é o RecycleView
    //itemView simula uma view do OnCreate, permitindo chamar o findViewById instanciando ela ou referenciando ela antes
    //O CepViewHolder manipula os itens da RecycleView
    class CepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvCep = itemView.findViewById<TextView>(R.id.tv_cep)
        val tvLogradouro = itemView.findViewById<TextView>(R.id.tv_logradouro)
        val tvLocalidade = itemView.findViewById<TextView>(R.id.tv_localidade)

    }

}