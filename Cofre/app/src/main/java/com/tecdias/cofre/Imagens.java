package com.tecdias.cofre;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class Imagens extends AppCompatActivity {

    // IDs referentes as imagens do grid
    int[] imageIds= {
            R.drawable.i1,
            R.drawable.i2,
            R.drawable.i3,
            R.drawable.i4,
            R.drawable.i5,
            R.drawable.i6,
            R.drawable.i7,
            R.drawable.i8,
            R.drawable.i9,
            R.drawable.i10,
            R.drawable.i11,
            R.drawable.i12,
            R.drawable.i13,
            R.drawable.i14,
            R.drawable.i15,
            R.drawable.i16,
            R.drawable.i17,
            R.drawable.i18,
            R.drawable.i19,
            R.drawable.i20,
            R.drawable.i21,
            R.drawable.i22,
            R.drawable.i23,
            R.drawable.i24,
            R.drawable.i25,
            R.drawable.i26,
            R.drawable.i27,
            R.drawable.i28,
            R.drawable.i29,
            R.drawable.i30,
            R.drawable.i31,
            R.drawable.i32,
            R.drawable.i33,
            R.drawable.i34,
            R.drawable.i35,
            R.drawable.i36,
            R.drawable.i37,
            R.drawable.i38,
            R.drawable.i39,
            R.drawable.i40,
            R.drawable.i41,
            R.drawable.i42,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagens);

        // Inicializando o GridView
GridView gridView = findViewById(R.id.gridFotos);
        // Configurando o adaptador para o GridView
        ImageAdapter imageAdapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(imageAdapter);
    }
}
