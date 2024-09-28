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
                String stringAlcool = editAlcool.getText().toString();
                String stringGasolina = editGasolina.getText().toString();
                double alcool = 0;
                double gasolina = 0;


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
                    textAviso.setText("Os dois campos precisam de valores para calcular o combustível ideal");
                }

                double resultado = alcool / gasolina;
                if (resultado==0){
                    System.out.println("Os campos estão vazios!");
                }
                else if (resultado < 0.7) {
                    System.out.println("Vale a pena usar alcool!");
                } else if (resultado > 0.7)
                    System.out.println("Vale a pena usar gasolina!");

            }
        });


    }
}
