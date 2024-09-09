package com.tecdias.testesudemy;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.constraint), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox homem = findViewById(R.id.homem);
        CheckBox mulher = findViewById(R.id.mulher);
        TextView texto = findViewById(R.id.txtCheckbox);
        RadioGroup radioGroup = findViewById(R.id.radioCores);
        RadioButton azul = findViewById(R.id.azul);
        RadioButton vermelho = findViewById(R.id.vermelho);
        RadioButton verde = findViewById(R.id.verde);
        Button btnmudaCor = findViewById(R.id.buttonMudaCor);
        ConstraintLayout layout = findViewById(R.id.constraint);


        // testando os radioButtons
        btnmudaCor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (azul.isChecked()) {
                    layout.setBackgroundColor(Color.BLUE);
                } else if (vermelho.isChecked()) {
                    layout.setBackgroundColor(Color.RED);
                } else layout.setBackgroundColor(Color.GREEN);
            }
        });

        // testando as checkboxes
        homem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homem.isChecked()) {
                    texto.setText("Macho");
                    mulher.setClickable(false);
                } else if (!homem.isChecked()) {
                    mulher.setClickable(true);
                    texto.setText("Escolha um sexo");

                }
            }
        });
        mulher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mulher.isChecked()) {
                    texto.setText("Fêmea");
                    homem.setClickable(false);
                } else if (!homem.isChecked()) {
                    homem.setClickable(true);
                    texto.setText("Escolha um sexo");
                }

            }
        });
    }
}