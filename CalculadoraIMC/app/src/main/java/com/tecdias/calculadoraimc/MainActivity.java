package com.tecdias.calculadoraimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double altura = Double.parseDouble(txtAltura.getText().toString());
                double peso = Double.parseDouble(txtPeso.getText().toString());
                double imc = peso / (Math.pow(altura, 2));

                DecimalFormatSymbols virgula = new DecimalFormatSymbols(new Locale("pt","BR"));
                DecimalFormat formatador = new DecimalFormat("#,##0.00", virgula);

                resultadoIMC.setText(formatador.format(imc));
            }
        });
    }
}