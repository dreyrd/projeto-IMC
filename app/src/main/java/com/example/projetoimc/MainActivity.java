package com.example.projetoimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText pesoInput;
    TextInputEditText alturaInput;
    TextView resultadoInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoInput = findViewById(R.id.pesoInput);
        alturaInput = findViewById(R.id.alturaInput);
        resultadoInput = findViewById(R.id.resultado);

    }

    public void calcular(View view){

        String peso = pesoInput.getText().toString();
        String altura = alturaInput.getText().toString();


        if (validarCampos(peso, altura)){

            Double valorPeso = Double.parseDouble(peso);
            Double valorAltura = Double.parseDouble(altura);
            Double imc = (valorPeso / Math.pow(valorAltura, 2));

            if (imc < 18.5) {
                resultadoInput.setText("Classificação: Abaixo do peso");
            } else if (imc >= 18.5 && imc < 24.9) {
                resultadoInput.setText("Classificação: Peso normal");
            } else if (imc >= 25 && imc < 29.9) {
                resultadoInput.setText("Classificação: Sobrepeso");
            } else if (imc >= 30 && imc < 34.9) {
                resultadoInput.setText("Classificação: Obesidade Grau I");
            } else if (imc >= 35 && imc < 39.9) {
                resultadoInput.setText("Classificação: Obesidade Grau II (severa)");
            } else {
                resultadoInput.setText("Classificação: Obesidade Grau III (mórbida)");
            }

        }
        else {
            resultadoInput.setText("Preencha corretamente os campos");
        }

    }

    public Boolean validarCampos(String peso, String altura){

        Boolean valido = true;

        if (peso == null || peso.isEmpty()){
            valido = false;
        }
        if (altura == null || altura.isEmpty()){
            valido = false;
        }

        return valido;
    }

}