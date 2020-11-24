package com.example.calculodoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.annotation.Documented;
import java.text.NumberFormat;

public class Resultado extends AppCompatActivity {
    TextView Peso, Altura;
    Button btVerificar;
    String calculaIMC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        Peso = findViewById(R.id.textViewPeso);
        Altura = findViewById(R.id.textViewAltura);
        btVerificar = findViewById(R.id.buttonVerificar);

        Intent i = getIntent();

        Bundle b = i.getExtras();

        double peso = Double.parseDouble(b.getString("KeyPeso"));
        double altura = Double.parseDouble(b.getString("KeyAltura"));

        // Formatar casas decimais do IMC.

        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1); // Formatar para calcular imc com 1 casa depois da vírgula.

        double imc = peso / (altura * altura);
        calculaIMC = nf.format(imc);

        Altura.setText(calculaIMC);


        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new
                        Intent(getApplicationContext(), Classificacao.class);

                Bundle b = new Bundle();

                b.putString("keyImc", calculaIMC);

                i.putExtras(b);

                startActivity(i);



            }
        });


    }
}