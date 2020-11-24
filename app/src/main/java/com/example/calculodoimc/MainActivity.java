package com.example.calculodoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Variávies

    int peso;
    float altura, imc;
    String calcular;

    // Atributos

    EditText varPeso;
    EditText varAltura;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associações que precisam

        varPeso = findViewById(R.id.editTextPeso);
        varAltura = findViewById(R.id.editTextAltura);
        btCalcular = findViewById(R.id.buttonCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Peso = varPeso.getText().toString();
                String Altura = varAltura.getText().toString();

                Bundle b = new Bundle();

                b.putString("KeyPeso", Peso);
                b.putString("KeyAltura", Altura);

                Intent i = new
                        Intent(getApplicationContext(), Resultado.class);


                i.putExtras(b);

                startActivity(i);

            }
        });



    }
}