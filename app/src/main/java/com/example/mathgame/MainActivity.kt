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
        val clientResult = findViewById<EditText>(R.id.editTextNumber)
        val textViewResultado = findViewById<TextView>(R.id.textView5)
        val buttonSoma = findViewById<Button>(R.id.button)
        val layoutPrincipal = findViewById<View>(R.id.main)
        val nextButton = findViewById<TextView>(R.id.passarButton)
        val notaFinal = findViewById<TextView>(R.id.textView9)
        val soma = findViewById<TextView>(R.id.textView2);
        val igual = findViewById<TextView>(R.id.textView4);
        var contador = 0;
        var pontos = 0;
        textViewNum1.text = gerarNumeroAleatorio(0, 99).toString();
        textViewNum2.text = gerarNumeroAleatorio(0, 99).toString();

        buttonSoma.setOnClickListener {
            nextButton.visibility = View.VISIBLE;

            if(contador < 5){
                val num1 = textViewNum1.text.toString().toInt()
                val num2 = textViewNum2.text.toString().toInt()
                val resultado = somar(num1, num2)
                textViewResultado.text = "$resultado"
                if(clientResult.text.toString() == resultado.toString()) {
                    layoutPrincipal.setBackgroundColor(Color.rgb(35,196,35));
                    pontos += 20;
                } else {
                    layoutPrincipal.setBackgroundColor(Color.RED)
                }
                nextButton.text = "Próxima!"
                contador++;
            }else{
                nextButton.text = "Finalizar Teste!"
            }

            buttonSoma.visibility = View.INVISIBLE;
        }

        nextButton.setOnClickListener {
            if(contador == 5){
                val totalDePontos = mostraNota(pontos)
                notaFinal.text = totalDePontos
                layoutPrincipal.setBackgroundColor(Color.BLACK);
                buttonSoma.visibility = View.INVISIBLE;
                notaFinal.visibility = View.VISIBLE;
                nextButton.visibility = View.INVISIBLE;
                textViewNum1.visibility = View.INVISIBLE;
                textViewNum2.visibility = View.INVISIBLE;
                clientResult.visibility = View.INVISIBLE;
                soma.visibility = View.INVISIBLE;
                igual.visibility = View.INVISIBLE;
                textViewResultado.visibility = View.INVISIBLE;
            }else{
                layoutPrincipal.setBackgroundColor(Color.BLACK);
                nextButton.visibility = View.INVISIBLE;
                buttonSoma.visibility = View.VISIBLE;

                textViewNum1.text = gerarNumeroAleatorio(0, 99).toString();
                textViewNum2.text = gerarNumeroAleatorio(0, 99).toString();
            }

            textViewResultado.text = "?";
            clientResult.text = null;
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