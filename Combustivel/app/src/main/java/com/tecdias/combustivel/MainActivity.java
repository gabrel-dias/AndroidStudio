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
        TextView textResultado = findViewById(R.id.textResultado);

        double alcool = 0;
        double gasolina = 0;

        String alcoolText = editAlcool.getText().toString();
        String gasolinaText = editGasolina.getText().toString();

        while (alcoolText.isEmpty()) {
            textResultado.setVisibility(View.VISIBLE);
            textResultado.setText("Digite o preço do álcool!");
        }

        while (gasolinaText.isEmpty()) {
            textResultado.setVisibility(View.VISIBLE);
            textResultado.setText("Digite o preço da gasolina!");
        }
        botaoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

/*
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Digite o preço do litro do alcool:");
	    double alcool = sc.nextDouble();
	    System.out.println("Digite o preço do litro da gasolina:");
	    double gasolina = sc.nextDouble();

	    double divisao = alcool/gasolina;
	    System.out.printf("%.2f\n", divisao);

	    if(alcool/gasolina < 0.7){
	        System.out.println("Vale a pena usar alcool!");
	    } else
	    System.out.println("Vale a pena usar gasolina!");

	}
}

========DICA COPILOT=========
double alcool = 0;
double gasolina = 0;

String alcoolText = editAlcool.getText().toString();
String gasolinaText = editGasolina.getText().toString();

if (alcoolText.isEmpty()) {
    System.out.println("Digite o preço do álcool!");
} else if (gasolinaText.isEmpty()) {
    System.out.println("Digite o preço da gasolina!");
} else {
    try {
        alcool = Double.parseDouble(alcoolText);
        gasolina = Double.parseDouble(gasolinaText);
    } catch (NumberFormatException e) {
        System.out.println("Por favor, insira valores numéricos válidos!");
    }
}

 */