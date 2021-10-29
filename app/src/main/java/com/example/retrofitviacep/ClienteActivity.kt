package com.example.retrofitviacep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClienteActivity : AppCompatActivity() {

    lateinit var edNome: EditText
    lateinit var edEmail: EditText
    lateinit var edTelefone: EditText
    lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        edNome = findViewById(R.id.edNome)
        edEmail = findViewById(R.id.edEmail)
        edTelefone = findViewById(R.id.edTelefone)
        btnSalvar = findViewById(R.id.btnSalvar)

    btnSalvar.setOnClickListener {
        val cliente = Cliente(
            0,
            edNome.text.toString(),
            edEmail.text.toString(),
            edTelefone.text.toString()
        )

        //Obter uma instância da conexão com o Backend
        val remote = RetrofitFactory().retrofitService()

        //Criar uma chamada para o endpoint /cep/json
        val call: Call<Cliente> = remote.gravarCliente(cliente)

        //Executar a chamada para a api
        call.enqueue(object : Callback<Cliente> {
            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                Toast.makeText(applicationContext, "deu certo!!", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Cliente>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    }
}