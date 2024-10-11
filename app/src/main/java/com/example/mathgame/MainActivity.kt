package com.example.mathgame

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textViewNum1: TextView = findViewById(R.id.textViewNum1)
        val textViewNum2: TextView = findViewById(R.id.textViewNum2)
        val textViewResultado: TextView = findViewById(R.id.textViewResultado)
        val buttonSoma: Button = findViewById(R.id.buttonSoma)

        buttonSoma.setOnClickListener {
            val num1 = textViewNum1.text.toString().toInt()
            val num2 = textViewNum2.text.toString().toInt()
            val resultado = somar(num1, num2)
            textViewResultado.text = "Resultado: $resultado"
        }
    }

    private fun somar(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}