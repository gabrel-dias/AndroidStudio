package com.tecdias.combustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        EditText editAlcool = findViewById(R.id.editAlcool);
        EditText editGasolina = findViewById(R.id.editGasolina);
        Button botaoCalculo = findViewById(R.id.botaoCalcular);
        TextView textAviso = findViewById(R.id.textAviso);
        TextView textResultado = findViewById(R.id.textResultado);

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // iniciando variáveis que receberão os valores dos campos do usuário
                double alcool = 0;
                double gasolina = 0;

                // verificando se os campos estão vazios com o método isEmpty() da classe String
                try {
                    String alcoolText = editAlcool.getText().toString();
                    String gasolinaText = editGasolina.getText().toString();
                    if (alcoolText.isEmpty() && !gasolinaText.isEmpty()) {
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o preço do álcool!");
                    } else {
                        alcool = Double.parseDouble(alcoolText);
                    }

                    if (gasolinaText.isEmpty() && !alcoolText.isEmpty()) {
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o preço da gasolina!");
                    } else {
                        gasolina = Double.parseDouble(gasolinaText);
                    }
                } catch (NumberFormatException e) {
                    textAviso.setText("Digite os dois valores");

                }
                double resultado = alcool / gasolina;


                if (resultado < 0.7d) {
                    textAviso.setVisibility(View.VISIBLE);
                    textAviso.setText("O resultado é zero\nDigite os dois campos!");
                } else if (resultado == 0.7d) {
                    textResultado.setVisibility(View.VISIBLE);
                    textResultado.setText("Vale a pena usar álcool!");
                } else
                    textResultado.setText("Vale a pena usar gasolina!");
            }
        });
    }
}
