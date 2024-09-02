package com.tecdias.frasesnerds;

/*
FRASES QUE SERÃO UTILIZADAS:
Bazinga! (The Big Bang Theory)
Não entre em pânico. (Guia do Mochileiro das Galáxias)
Que a Força esteja com você! (Star Wars)
Com grandes poderes, vem grandes responsabilidades. (Homem-Aranha)
O inverno está chegando. (Game of Thrones)
São as nossas escolhas, Harry, que revelam o que realmente somos, muito mais do que as nossas qualidades. (Harry Potter)
A mente é uma coisa frágil. Basta a mínima coisa para ir na direção errada. (X-Men)
Não brinque com o nerd de sua turma, pois um dia ele pode ser seu chefe. (Bill Gates)
It's bigger on the inside! (Qualquer um ao entrar na TARDIS pela primeira vez em Doctor Who)
One ring to rule them all (Senhor dos Anéis)
*/

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
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

        // relacionando os elementos do Java aos da interface gráfica
        Button gerarFrase = findViewById(R.id.btnGerar);
        TextView frase = findViewById(R.id.txtFrase);

        // deixando as frases inicias sem visibilidade
        frase.setVisibility(View.INVISIBLE);

        // efeito do botão quando clicado
        gerarFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // criando um HashMap com 10 frases nerds
                Map<Integer, String> mapFrasesGeradas = new HashMap() {
                    {
                        put(0, "\"Seu futuro não está escrito, o de ninguém está. Você pode fazer o que quiser fazer.\"\n(De Volta Para o Futuro)");
                        put(1, "\"Não entre em pânico!\"\n(Guia do Mochileiro das Galáxias)");
                        put(2, "\"Que a Força esteja com você!\"\n(Star Wars)");
                        put(3, "\"Com grandes poderes, vem grandes responsabilidades.\"\n(Homem-Aranha)");
                        put(4, "\"O inverno está chegando.\"\n(Game of Thrones)");
                        put(5, "\"Não são as nossas qualidades, mas sim as nossas escolhas que revelam quem nós somos.\"\n(Harry Potter)");
                        put(6, "\"Existe sempre uma solução.\"\n(Doctor Who)");
                        put(7, "\"Não deixe os trouxas te colocarem para baixo.\"\n(Harry Potter)");
                        put(8, "\"It's bigger on the inside!\"\n(Qualquer um ao entrar na TARDIS pela primeira vez em Doctor Who)");
                        put(9, "\"One ring to rule them all.\"\n(Senhor dos Anéis)");
                    }
                };

                // deixando a frase visível
                frase.setVisibility(View.VISIBLE);

                // usando Random para criar uma chave aleatória e poder resgatar um valor contido no map
                Random valor = new Random();
                int valorGerado = valor.nextInt(10);
                frase.setText(mapFrasesGeradas.get(valorGerado));
            }
        });

    }
}
