package com.tecdias.conversordemoedas;

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

        // relacionando os elementos da Activity principal aos da GUI no XML (essa relação não é automática)
        Button btnConverterReal = findViewById(R.id.btnConverter);
        EditText txtQtdDolar = findViewById(R.id.txtQuantiaDolares);
        TextView txtQtdReal = findViewById(R.id.txtResultado);

        // criando um listener para usar o botão
        btnConverterReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // usando a cotação de: 26 de ago., 00:46 UTC · Fontes
                double dolar = 5.49d * Double.parseDouble(txtQtdDolar.getText().toString());

                // formatando a saída com vírgula e casas decimais compatíveis
                DecimalFormatSymbols decimalVirgula = new DecimalFormatSymbols(Locale.getDefault());
                decimalVirgula.setDecimalSeparator(',');
                DecimalFormat formatarValor = new DecimalFormat("#,##0.00", decimalVirgula);
                txtQtdReal.setText("R$" + formatarValor.format(dolar));
            }
        });
    }
}