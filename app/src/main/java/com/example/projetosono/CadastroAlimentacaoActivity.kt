package com.example.projetosono

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroAlimentacaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_alimentacao)

        val inputHorario = findViewById<EditText>(R.id.inputHorario)
        val inputTipo = findViewById<EditText>(R.id.inputTipo)
        val inputQtd = findViewById<EditText>(R.id.inputQuantidade)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarAlimentacao)

        btnSalvar.setOnClickListener {
            val horario = inputHorario.text.toString()
            val tipo = inputTipo.text.toString()
            val qtd = inputQtd.text.toString()

            if (horario.isEmpty() || tipo.isEmpty() || qtd.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                // Salvar alimentação
                Toast.makeText(this, "Alimentação salva com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}