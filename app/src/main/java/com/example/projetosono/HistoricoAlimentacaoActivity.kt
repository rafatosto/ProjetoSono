package com.example.projetosono

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HistoricoAlimentacaoActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val registrosAlimentacao = mutableListOf(
        "08:00 - Leite - 150ml",
        "12:00 - Papinha - 200ml"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_alimentacao)

        listView = findViewById(R.id.listAlimentacao)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, registrosAlimentacao)
        listView.adapter = adapter

        listView.setOnItemLongClickListener { _, _, position, _ ->
            AlertDialog.Builder(this)
                .setTitle("Excluir")
                .setMessage("Deseja excluir este registro?")
                .setPositiveButton("Sim") { _, _ ->
                    registrosAlimentacao.removeAt(position)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("Cancelar", null)
                .show()
            true
        }
    }
}
