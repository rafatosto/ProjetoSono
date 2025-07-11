package com.example.projetosono

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var buttonSair: Button = findViewById(R.id.botao_sair)
        buttonSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnCadastrarSono = findViewById<LinearLayout>(R.id.btnCadastrarSono)
        btnCadastrarSono.setOnClickListener {
            val intent = Intent(this, CadastroSonoActivity::class.java)
            startActivity(intent)
        }

        val btnCadastrarAlimentacao = findViewById<LinearLayout>(R.id.btnCadastrarAlimentacao)
        btnCadastrarAlimentacao.setOnClickListener {
            val intent = Intent(this, CadastroAlimentacaoActivity::class.java)
            startActivity(intent)
        }

        val btnSono = findViewById<Button>(R.id.btnSono)
        btnSono.setOnClickListener {
            val intent = Intent(this, HistoricoSonoActivity::class.java)
            startActivity(intent)
        }

        val btnAlimentacao = findViewById<Button>(R.id.btnAlimentacao)
        btnAlimentacao.setOnClickListener {
            val intent = Intent(this, HistoricoAlimentacaoActivity::class.java)
            startActivity(intent)
        }
    }
}
