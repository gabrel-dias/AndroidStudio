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
        TextView textAviso = findViewById(R.id.textAviso);
        TextView textResultado = findViewById(R.id.textResultado);
        Button botaoCalculo = findViewById(R.id.botaoCalcular);

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textAviso.setVisibility(View.INVISIBLE);
                textResultado.setVisibility(View.INVISIBLE);
                String stringAlcool = editAlcool.getText().toString();
                String stringGasolina = editGasolina.getText().toString();
                double alcool = 0;
                double gasolina = 0;
                double resultado;

                /* verificações dos campos individualmente
                 if (stringGasolina.isEmpty() && stringAlcool.isEmpty()) {
                    textAviso.setText("Digite os valores de álcool e gasolina!");
                }
                // verifica se o campo da gasolina está vazio e o álcool não
                else if (stringGasolina.isEmpty() && !stringAlcool.isEmpty()) {
                    textAviso.setText("Digite o preço da gasolina!");
                    // verifica se o campo da gasolina está vazio e o álcool não
                } else if (!stringGasolina.isEmpty() && stringAlcool.isEmpty()) {
                    textAviso.setText("Digite o preço do álcool!");
                }*/
                try {
                    alcool = Double.parseDouble(stringAlcool);
                    gasolina = Double.parseDouble(stringGasolina);
                } catch (NumberFormatException e) {
                    if (stringAlcool.isEmpty()) {
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o valor no campo do álcool");
                    } else if (stringGasolina.isEmpty()) {
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o valor no campo da gasolina");
                    }
                }
                textAviso.setVisibility(View.INVISIBLE);
                resultado = alcool / gasolina;

                if (resultado <= 0.7) {
                    textResultado.setVisibility(View.VISIBLE);
                    textResultado.setText("Vale a pena usar alcool!");
                    if (stringAlcool.isEmpty() || stringGasolina.isEmpty()) {
                        textResultado.setVisibility(View.INVISIBLE);
                    }
                } else {
                    textResultado.setVisibility(View.VISIBLE);
                    textResultado.setText("Vale a pena usar gasolina!");
                    if (stringAlcool.isEmpty() || stringGasolina.isEmpty()) {
                        textResultado.setVisibility(View.INVISIBLE);
                    }
                }

            }
        });


    }
}
