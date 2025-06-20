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

        btnSalvar.setOnClickListener {
            val inicio = inputInicio.text.toString()
            val fim = inputFim.text.toString()

            if (inicio.isEmpty() || fim.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                // Aqui você pode salvar os dados no banco ou ViewModel
                Toast.makeText(this, "Sono salvo com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}
