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

        val textViewNum1 = findViewById<TextView>(R.id.textView)
        val textViewNum2 = findViewById<TextView>(R.id.textView3)
        val clientResult = findViewById<EditText>(R.id.editTextNumber).toString().toInt()
        val textViewResultado = findViewById<TextView>(R.id.textView5)
        val buttonSoma = findViewById<Button>(R.id.button)
        val layoutPrincipal = findViewById<View>(R.id.main)
        val nextButton = findViewById<TextView>(R.id.passarButton)
        val notaFinal = findViewById<TextView>(R.id.textView9)
        var contador = 0;
        var pontos = 0;
        textViewNum1.text = gerarNumeroAleatorio(0, 99).toString();
        textViewNum2.text = gerarNumeroAleatorio(0, 99).toString();

        buttonSoma.setOnClickListener {
            if(contador < 4){
                val num1 = textViewNum1.text.toString().toInt()
                val num2 = textViewNum2.text.toString().toInt()
                val resultado = somar(num1, num2)
                textViewResultado.text = "$resultado"
                if(clientResult == resultado) {
                    layoutPrincipal.setBackgroundColor(Color.GREEN)
                    pontos += 20;
                } else {
                    layoutPrincipal.setBackgroundColor(Color.RED)
                }
                nextButton.text = "Próxima!"
                // Espere por 3 segundos
                textViewNum1.text = gerarNumeroAleatorio(0, 99).toString();
                textViewNum2.text = gerarNumeroAleatorio(0, 99).toString();

                contador++;
            }else{
                // Implementar
                nextButton.text = "Finalizar Teste!"
            }
        }

        nextButton.setOnClickListener {
            if(contador < 4){
                val totalDePontos = mostraNota(pontos)
                notaFinal.text = totalDePontos
            }
        }
    }

    private fun somar(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    private fun gerarNumeroAleatorio(min: Int, max: Int): Int {
        return Random.nextInt(min, max + 1)
    }

    private fun mostraNota(nota: Int): String {
        return "Sua nota no jogo foi: $nota"
    }

}