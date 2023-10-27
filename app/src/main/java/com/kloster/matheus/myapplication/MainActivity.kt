package com.kloster.matheus.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Campo da fórmula
        var txtFormula = findViewById<TextView>(R.id.txtFormula)

        // Campo do input
        val txtInput = findViewById<TextView>(R.id.txtInput)
        txtInput.setText("0");

        var resultado:Double = 0.00
        var entradas = 0;
        var ultimaOperacao:String = "";
        var formula:String = "";


        // Botões numéricos
        val btnUm = findViewById<Button>(R.id.btnUm)
        val btnDois = findViewById<Button>(R.id.btnDois)
        val btnTres = findViewById<Button>(R.id.btnTres)
        val btnQuatro = findViewById<Button>(R.id.btnQuatro)
        val btnCinco = findViewById<Button>(R.id.btnCinco)
        val btnSeis = findViewById<Button>(R.id.btnSeis)
        val btnSete = findViewById<Button>(R.id.btnSete)
        val btnOito = findViewById<Button>(R.id.btnOito)
        val btnNove = findViewById<Button>(R.id.btnNove)
        val btnZero = findViewById<Button>(R.id.btnZero)
        val btnPonto = findViewById<Button>(R.id.btnPonto)

        // Botões de operação
        val btnSoma = findViewById<Button>(R.id.btnSoma)
        val btnSubtracao = findViewById<Button>(R.id.btnSubtracao)
        val btnDivisao = findViewById<Button>(R.id.btnDivisao)
        val btnMultiplicacao = findViewById<Button>(R.id.btnMultiplicacao)
        val btnIgual = findViewById<Button>(R.id.btnIgual)

        //Botões de comando
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnClearEntry = findViewById<Button>(R.id.btnClearEntry)

        fun onNumericButtonClick(button: Button) {
            val value = button.text.toString()
            if (txtInput.text == "0"){
                txtInput.text = value;
            } else {
                txtInput.text = "${txtInput.text}$value"
            }

        }


        fun calcular(operacao: String){
            var inputDouble = txtInput.text.toString().toDouble()
           if (entradas != 0) {
               if (txtInput.text.isEmpty()) {
                   println("Skip")
               } else {
                   if (operacao == "+") {
                       resultado += inputDouble
                   } else if (operacao == "-") {
                       resultado -= inputDouble
                   } else if (operacao == "÷") {

                       resultado /= inputDouble
                   } else if (operacao == "X") {

                       resultado *= inputDouble
                   } else if (operacao == "=") {
                       calcular(ultimaOperacao);
                   }
               }
           } else {
               resultado = inputDouble;
           }
            entradas++;
        }


        fun limparCampoInput() {
            txtInput.setText("");
        }

        fun onOperationButtonClick(button: Button) {
            if (txtInput.text.isEmpty()){
                ultimaOperacao = button.text.toString();
            } else {
                calcular(button.text.toString())
                limparCampoInput()
                txtFormula.setText(resultado.toString());
                ultimaOperacao = button.text.toString();
            }



        }

        btnUm.setOnClickListener {onNumericButtonClick(btnUm);}
        btnDois.setOnClickListener {onNumericButtonClick(btnDois);}
        btnTres.setOnClickListener {onNumericButtonClick(btnTres);}
        btnQuatro.setOnClickListener {onNumericButtonClick(btnQuatro);}
        btnCinco.setOnClickListener {onNumericButtonClick(btnCinco);}
        btnSeis.setOnClickListener {onNumericButtonClick(btnSeis);}
        btnSete.setOnClickListener {onNumericButtonClick(btnSete);}
        btnOito.setOnClickListener {onNumericButtonClick(btnOito);}
        btnNove.setOnClickListener {onNumericButtonClick(btnNove);}
        btnZero.setOnClickListener {onNumericButtonClick(btnZero);}
        btnPonto.setOnClickListener {onNumericButtonClick(btnPonto);}

        btnSoma.setOnClickListener {onOperationButtonClick(btnSoma);}
        btnSubtracao.setOnClickListener {onOperationButtonClick(btnSubtracao);}
        btnMultiplicacao.setOnClickListener {onOperationButtonClick(btnMultiplicacao);}
        btnDivisao.setOnClickListener {onOperationButtonClick(btnDivisao);}
        btnIgual.setOnClickListener {onOperationButtonClick(btnIgual);}





        btnClear.setOnClickListener {
            txtFormula.text = ""
            txtInput.text = ""
            resultado = 0.00
            entradas = 0;
        }

        btnClearEntry.setOnClickListener {
            limparCampoInput()
        }



    }


}