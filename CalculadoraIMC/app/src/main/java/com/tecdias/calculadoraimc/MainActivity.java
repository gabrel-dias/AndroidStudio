package com.tecdias.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button botaoCalculo = findViewById(R.id.btnCalcular);
        TextView txtAltura = findViewById(R.id.txtAltura);
        TextView txtPeso = findViewById(R.id.txtPeso);
        TextView resultadoIMC = findViewById(R.id.txtResultado);
        TextView classificacao = findViewById(R.id.txtClassificacao);
        ImageView formula = findViewById(R.id.formula);

        classificacao.setVisibility(View.INVISIBLE);
        resultadoIMC.setVisibility(View.INVISIBLE);

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double altura = Double.parseDouble(txtAltura.getText().toString());
                double peso = Double.parseDouble(txtPeso.getText().toString());
                double imc = peso / (Math.pow(altura, 2));

                DecimalFormatSymbols virgula = new DecimalFormatSymbols(new Locale("pt", "BR"));
                DecimalFormat formatador = new DecimalFormat("#,##0.00", virgula);

                resultadoIMC.setText(formatador.format(imc));

                formula.setVisibility(View.INVISIBLE);
                classificacao.setVisibility(View.VISIBLE);
                if (imc <= 18.5d) {
                    classificacao.setText("Seu IMC foi classificado como: \"Baixo peso\"");
                } else if (imc > 18.d && imc <= 24.9d) {
                    classificacao.setText("Seu IMC foi classificado como: \"Eutrofia (peso adequado)\"");
                } else if (imc > 25d && imc <= 29.d) {
                    classificacao.setText("Seu IMC foi classificado como: \"Sobrepeso\"");
                } else if (imc > 30d && imc <= 34.9) {
                    classificacao.setText("Seu IMC foi classificado como: \"Obesidade Grau 1\"");
                } else if (imc > 35d && imc <= 39.9d) {
                    classificacao.setText("Seu IMC foi classificado como: \"Obesidade Grau 2\"");
                } else
                    classificacao.setText("Seu IMC foi classificado como: \"Obesidade Extrema\"");
            }
        });
    }
}