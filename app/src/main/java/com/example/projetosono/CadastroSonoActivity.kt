package com.example.projetosono

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroSonoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_sono)

        val inputInicio = findViewById<EditText>(R.id.inputHorarioInicio)
        val inputFim = findViewById<EditText>(R.id.inputHorarioFim)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarSono)
        val db = DatabaseHelper(this)

        btnSalvar.setOnClickListener {
            val inicio = inputInicio.text.toString().trim()
            val fim = inputFim.text.toString().trim()

            if (inicio.isEmpty() || fim.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                val resultado = db.inserirSono(inicio, fim)
                if (resultado != -1L) {
                    Toast.makeText(this, "Sono salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Erro ao salvar sono.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
