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

        val db = DatabaseHelper(this)

        btnSalvar.setOnClickListener {
            val horario = inputHorario.text.toString().trim()
            val tipo = inputTipo.text.toString().trim()
            val qtd = inputQtd.text.toString().trim()

            if (horario.isEmpty() || tipo.isEmpty() || qtd.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = db.inserirAlimentacao(horario, tipo, qtd)
                if (resultado != -1L) {
                    Toast.makeText(this, "Alimentação salva com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao salvar alimentação.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}