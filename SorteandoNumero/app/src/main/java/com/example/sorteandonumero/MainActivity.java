package com.example.sorteandonumero;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

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
        System.out.println("onCreate chamado!");
    }

    public void sortearNumero(View view) {
        Random aleatorio = new Random();
        // gera um número aleatório de 0 (inclusivo) até o limite do range escolhido (exclusivo, ou seja -1. por isso é preciso colocar um a mais no range)
        int numeroAleatorio = aleatorio.nextInt(11);
        TextView numero = findViewById(R.id.txtNumeroSorteado);
        numero.setText(Integer.toString(numeroAleatorio));

    }

    // testando os ciclos de vida e seus callbacks
    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart chamado!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume chamado!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onpause chamado!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop chamado!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy chamado");
    }
}