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
        textAviso.setVisibility(View.INVISIBLE);
        textResultado.setVisibility(View.INVISIBLE);

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // atribuindo os valores dos campos em Strings
                String stringAlcool = editAlcool.getText().toString();
                String stringGasolina = editGasolina.getText().toString();
                double alcool = 0;
                double gasolina = 0;
                double resultado;

                try {
                    // converte os valores das strings em double, o que irá gerar uma exceção se
                    // os campos estiverem vazios
                    alcool = Double.parseDouble(stringAlcool);
                    gasolina = Double.parseDouble(stringGasolina);
                } catch (NumberFormatException e) {
                    // caso haja a exceção NumberFormatException, são feitas verificações para
                    // descobrir qual dos campos está vazio e então gerar uma mensagem orientando
                    // o usuário
                    if (stringGasolina.isEmpty() && stringAlcool.isEmpty()) {
                        // os dois campos estão vazios
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite os dois valores");
                    } else if (stringAlcool.isEmpty()) {
                        // apenas um dos campos está vazio
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o valor do álcool");
                    } else if (stringGasolina.isEmpty()) {
                        textAviso.setVisibility(View.VISIBLE);
                        textAviso.setText("Digite o valor da gasolina");
                    }
                }
                // aplica a "regra dos 70%" para descobrir qual combustível é mais vantajoso
                resultado = alcool / gasolina;
                System.out.println(resultado);

                textResultado.setVisibility(View.VISIBLE);

                if (stringAlcool.isEmpty() || stringGasolina.isEmpty()) {
                    // verifica se algum dos campos ficou vazio e esconde o resultado,
                    // pois o valor da divisão será zero
                    textResultado.setVisibility(View.INVISIBLE);
                }
                if (!stringGasolina.isEmpty() && !stringAlcool.isEmpty()) {
                    // se nenhum dos campos estiver vazio, a mensagem orientando o usuário irá desaparecer
                    textAviso.setVisibility(View.INVISIBLE);
                    if (resultado <= 0.7) {
                        // define o melhor com base no resultado da divisão entre os dois valores
                        textResultado.setText("Vale a pena usar álcool!");
                    } else {
                        textResultado.setText("Vale a pena usar gasolina!");
                    }
                }
            }
        });
    }
}
