package com.tecdias.calculadoraimc;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        classificacao.setVisibility(View.INVISIBLE);
        resultadoIMC.setVisibility(View.INVISIBLE);
        Button btnTabela = findViewById(R.id.btnTabela);
        btnTabela.setVisibility(View.INVISIBLE);

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            int imc;
            double altura;
            double peso;

            @Override
            // tratamento de exceção para garantir que o programa continue rodando e prevenindo seu encerramento caso um dos campos esteja vazio
            public void onClick(View v) {
                try {
                    altura = Double.parseDouble(txtAltura.getText().toString());
                    peso = Double.parseDouble(txtPeso.getText().toString());
                    imc = (int) Math.floor(peso / (Math.pow(altura, 2)));

                    resultadoIMC.setText("Seu IMC é: " + Integer.toString(imc));
                    resultadoIMC.setVisibility(View.VISIBLE);
                } catch (NumberFormatException e) {
                    resultadoIMC.setText("Por favor, preencha os dois campos acima!");
                    resultadoIMC.setVisibility(View.VISIBLE);
                }
                // verifica se algum dos campos ficou vazio, se sim a classificação do IMC não ficará visível
                if (altura == 0 || peso == 0) {
                    classificacao.setVisibility(View.INVISIBLE);

                } else {
                    classificacao.setVisibility(View.VISIBLE);
                    // aparece um botão para chamar uma nova activity com a foto de uma tabela classificando o IMC
                    btnTabela.setVisibility(View.VISIBLE);
                }

                // condicionais para classificação do IMC e colocando uma cor em cada situação
                if (imc <= 18) {
                    classificacao.setText("Baixo peso");
                    classificacao.setTextColor(Color.parseColor("#63CAF2"));

                } else if (imc >= 20 && imc <= 24) {
                    classificacao.setText("Peso Normal");
                    classificacao.setTextColor(Color.parseColor("#3098F2"));

                } else if (imc >= 25 && imc <= 29) {
                    classificacao.setText("Excesso de peso");
                    classificacao.setTextColor(Color.parseColor("#5204BF"));

                } else if (imc >= 30 && imc <= 35) {
                    classificacao.setText("Obesidade");
                    classificacao.setTextColor(Color.parseColor("#F2B705"));

                } else {
                    classificacao.setText("Super Obesidade");
                    classificacao.setTextColor(Color.parseColor("#A6032F"));
                }
            }
        });
        // chamda do botão que mostra a tabela com a classificação do IMC
        btnTabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaTabela = new Intent(MainActivity.this, TelaTabela.class);
                startActivity(telaTabela);
            }
        });
    }
}
