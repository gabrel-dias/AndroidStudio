package com.tecdias.cofre;

import android.content.Intent;
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

        // atribuiindo credenciais padrão para login
        String admin = "root";
        String password = "root";
        // elementos que ficarão invisíveis até que as credenciais digitadas sejam válidas
        credencial.setVisibility(View.INVISIBLE);
        entrar.setVisibility(View.INVISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // coleta o texto que foi digitado nos campos de login
                String usuarioString = usuario.getText().toString();
                String senhaString = senha.getText().toString();

                if (admin.equals(usuarioString) && password.equals(senhaString)) {
                    // executado apenas se os dois campos estiverem corretos com as credencias
                    // pré definidas e também mostra os elementos desbloqueados com o login válido
                    credencial.setVisibility(View.VISIBLE);
                    credencial.setText("Acesso liberado!");
                    entrar.setVisibility(View.VISIBLE);
                    // troca a imagem para um cadeado destrancado
                    cadeado.setImageResource(R.drawable.destrancado);
                } else {
                    // caso um dos campos estejam errados, o botão para tela seguinte não é liberado
                    // e o resultado das credenciais digitadas é mostrado
                    credencial.setVisibility(View.VISIBLE);
                    credencial.setText("Acesso negado!");
                    entrar.setVisibility(View.INVISIBLE);
                }
            }
        });
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chama uma nova atividade com o conteúdo do cofre
                Intent intent = new Intent(MainActivity.this, Imagens.class);
                startActivity(intent);
            }
        });
    }
}