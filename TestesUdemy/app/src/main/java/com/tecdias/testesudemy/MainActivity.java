package com.tecdias.testesudemy;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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

        ConstraintLayout layout = findViewById(R.id.constraint);


        RadioGroup radioGroup = findViewById(R.id.radioCores);
        RadioButton azul = findViewById(R.id.azul);
        RadioButton vermelho = findViewById(R.id.vermelho);
        RadioButton verde = findViewById(R.id.verde);
        Button btnmudaCor = findViewById(R.id.buttonMudaCor);
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

        CheckBox homem = findViewById(R.id.homem);
        CheckBox mulher = findViewById(R.id.mulher);
        TextView texto = findViewById(R.id.txtCheckbox);
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

        //testando toggle buttons
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggleButton.isChecked()) {
                    layout.setBackgroundColor(Color.BLACK);
                } else layout.setBackgroundColor(Color.CYAN);
            }
        });

        // testando spinners + adaptadores
        Spinner spnPaises = findViewById(R.id.spinnerPaises);
        TextView pais = findViewById(R.id.txtPais);

        // para linkar um array de strings que está presente no arquivo XML a um spinner, é preciso utilizar um adaptador
        // DataSourse <--> Adapter <--> AdapterView

        // DataSourse = Cursor, Arraylist;
        // Adapter View = List View, Grid View, Spinner.

        ArrayAdapter adaptador = ArrayAdapter.createFromResource(this, R.array.paises, android.R.layout.simple_spinner_item);
        // usando o método createFromResource() é preciso fornecer 3 parâmetros:
        // context – em que contexto ele será utilizado e será nessa classe (this);
        // textArrayResId – o identificador do array que será usado como código, usando o nome desse array que está XML;
        // textViewResId – o identificador do layout que será usado para criar a visualização, em outras palavras é como o item irá aparecer dentro do spínner.

        // após isso, é preciso "criar" um layout dentro desse spínner, setando o mesmo como dropdown
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPaises.setAdapter(adaptador);
        // TODO spnPaises.setOnItemSelectedListener();

    }
}