package com.tecdias.cofre;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
    ImageView cadeado = findViewById(R.id.iconCadeado);
    EditText usuario = findViewById(R.id.editUser);
    EditText senha = findViewById(R.id.editPass);
    Button login = findViewById(R.id.btnLogin);
    TextView credencial = findViewById(R.id.txtAcesso);
    Button entrar = findViewById(R.id.btnEntrar);

    String admin = "root";
    String password = "root";
    credencial.setVisibility(View.INVISIBLE);
    entrar.setVisibility(View.INVISIBLE);

    login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    String usuarioString = usuario.getText().toString();
    String senhaString = senha.getText().toString();
            if (admin.equals(usuarioString) && password.equals(senhaString)) {
                credencial.setVisibility(View.VISIBLE);
                credencial.setText("Acesso liberado!");
                entrar.setVisibility(View.VISIBLE);
                cadeado.setImageResource(R.drawable.destrancado);
            } else{
                credencial.setVisibility(View.VISIBLE);
                credencial.setText("Acesso negado!");
                entrar.setVisibility(View.INVISIBLE);

            }
        }
    });
    }
}