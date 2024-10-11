package com.example.mathgame

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

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
        val textViewNum1  = findViewById<TextView>(R.id.textView)
        val textViewNum2  = findViewById<TextView>(R.id.textView3)
        val clientResult = findViewById<EditText>(R.id.editTextNumber).toString().toInt()
        val textViewResultado = findViewById<TextView>(R.id.textView5)
        val buttonSoma = findViewById<Button>(R.id.button)
        val layoutPrincipal = findViewById<View>(R.id.main)

        buttonSoma.setOnClickListener {
            val num1 = textViewNum1.text.toString().toInt()
            val num2 = textViewNum2.text.toString().toInt()
            val resultado = somar(num1, num2)
            textViewResultado.text = "$resultado"
            if(clientResult == resultado) {
                layoutPrincipal.setBackgroundColor(Color.GREEN)
            } else {
                layoutPrincipal.setBackgroundColor(Color.RED)
            }
        }
    }

    private fun somar(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    private fun gerarNumeroAleatorio(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }
}