package com.example.calculodoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Classificacao extends AppCompatActivity {

    int peso;
    float altura;
    String calculaIMC;

    TextView classificacao;
    Button calcnovamente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classificacao);

        Intent i = getIntent();

        Bundle b = i.getExtras();

        double imc = Double.parseDouble(b.getString("keyImc"));

        classificacao = findViewById(R.id.textViewClass);
        calcnovamente = findViewById(R.id.buttonCalNovamente);

       if (imc < 18.5) {
            calculaIMC = "Abaixo do peso";
        }
        else if(imc < 24.9) {
            calculaIMC = "Peso Normal";
        }
        else if(imc < 29.9) {
            calculaIMC = "Sobrepeso";
        }
        else if(imc < 34.9) {
           calculaIMC= "Obesidade Grau I";
        }
        else if(imc < 39.9) {
           calculaIMC = "Obesidade Grau II";
      }
        else {
           calculaIMC = "Obesidade Grau III ou mórbido";
        }

        classificacao.setText(calculaIMC);



        calcnovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }


        });


    }
}