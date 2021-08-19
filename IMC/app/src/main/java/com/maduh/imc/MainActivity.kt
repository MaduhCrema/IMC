package com.maduh.imc

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(R.id.calcular_button)
        val altura = findViewById<EditText>(R.id.input_altura)
        val peso = findViewById<EditText>(R.id.input_peso)

        botao.setOnClickListener{
            calculoIMC(peso.text.toString(),altura.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculoIMC(peso:String, altura:String){
        val resultado = findViewById<TextView>(R.id.resultado)
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if(altura != null && peso != null){
            val resultadoIMC = peso/(altura*altura)
            resultado.text= "Resultado IMC = %.2f".format(resultadoIMC)
        }
    }


}