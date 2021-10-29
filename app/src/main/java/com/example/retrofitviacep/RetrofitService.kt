package com.example.retrofitviacep

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

//    Método que será responsável por chamar a api
//    https://viacep.com.br/ws/01001000/json/

    @GET  ("{CEP}/json")
    fun getCep(@Path("CEP")cep: String) : Call<Cep>

    @GET  ("{uf}/{cidade}/{logradouro}/json")
    fun getCEPByLogradouro(@Path("uf")uf: String,
                           @Path("cidade")cidade: String,
                           @Path("logradouro")logradouro: String) : Call<List<Cep>>

//    @POST ("/ceps")
//    fun gravarCep(@Body cep: Cep) : Call<Cep>{}


    @DELETE ("/ceps/{id}")
    fun excluir(@Path("id")id: Int){

    }

    @POST("clientes")
    fun gravarCliente(@Body cliente: Cliente) : Call<Cliente>

}