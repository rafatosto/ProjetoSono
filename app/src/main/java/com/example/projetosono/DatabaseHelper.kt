package com.example.projetosono

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "bebe.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE sono (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                inicio TEXT NOT NULL,
                fim TEXT NOT NULL
            )
        """)

        db.execSQL("""
            CREATE TABLE alimentacao (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                horario TEXT NOT NULL,
                tipo TEXT NOT NULL,
                quantidade TEXT NOT NULL
            )
        """)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS sono")
        db.execSQL("DROP TABLE IF EXISTS alimentacao")
        onCreate(db)
    }

    // metodos para o sono
    fun inserirSono(inicio: String, fim: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("inicio", inicio)
            put("fim", fim)
        }
        return db.insert("sono", null, values)
    }

    fun listarSono(): List<String> {
        val lista = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM sono", null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val inicio = cursor.getString(1)
            val fim = cursor.getString(2)
            lista.add("$id: $inicio - $fim")
        }
        cursor.close()
        return lista
    }

    fun excluirSono(id: Int) {
        writableDatabase.delete("sono", "id = ?", arrayOf(id.toString()))
    }

    // metodos para alimentação
    fun inserirAlimentacao(horario: String, tipo: String, quantidade: String): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put("horario", horario)
            put("tipo", tipo)
            put("quantidade", quantidade)
        }
        return db.insert("alimentacao", null, values)
    }

    fun listarAlimentacao(): List<String> {
        val lista = mutableListOf<String>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM alimentacao", null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val horario = cursor.getString(1)
            val tipo = cursor.getString(2)
            val qtd = cursor.getString(3)
            lista.add("$id: $horario - $tipo - $qtd")
        }
        cursor.close()
        return lista
    }

    fun excluirAlimentacao(id: Int) {
        writableDatabase.delete("alimentacao", "id = ?", arrayOf(id.toString()))
    }
}
