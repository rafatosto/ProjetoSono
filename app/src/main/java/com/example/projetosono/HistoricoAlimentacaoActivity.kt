package com.example.projetosono

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HistoricoAlimentacaoActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var registrosAlimentacao: MutableList<String>
    private lateinit var db: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico_alimentacao)

        db = DatabaseHelper(this)
        listView = findViewById(R.id.listAlimentacao)

        carregarDados()

        listView.setOnItemLongClickListener { _, _, position, _ ->
            val item = registrosAlimentacao[position]
            val id = item.substringBefore(":").toIntOrNull()

            if (id != null) {
                AlertDialog.Builder(this)
                    .setTitle("Excluir")
                    .setMessage("Deseja excluir esse registro?")
                    .setPositiveButton("Sim") { _, _ ->
                        db.excluirAlimentacao(id)
                        carregarDados()
                        Toast.makeText(this, "Registro excluído", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            } else {
                Toast.makeText(this, "ID inválido", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    private fun carregarDados() {
        registrosAlimentacao = db.listarAlimentacao().toMutableList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, registrosAlimentacao)
        listView.adapter = adapter
    }
}
