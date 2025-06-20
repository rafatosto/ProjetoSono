package com.example.projetosono

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HistoricoSonoActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val registrosSono = mutableListOf("22:00 - 06:00", "13:00 - 14:30") // Simulação

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_sono)

        listView = findViewById(R.id.listSono)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, registrosSono)
        listView.adapter = adapter

        listView.setOnItemLongClickListener { _, _, position, _ ->
            AlertDialog.Builder(this)
                .setTitle("Excluir")
                .setMessage("Deseja excluir este registro?")
                .setPositiveButton("Sim") { _, _ ->
                    registrosSono.removeAt(position)
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("Cancelar", null)
                .show()
            true
        }
    }
}
