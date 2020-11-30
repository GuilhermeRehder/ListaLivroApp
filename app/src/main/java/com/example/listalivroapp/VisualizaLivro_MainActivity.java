package com.example.listalivroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisualizaLivro_MainActivity extends AppCompatActivity {

    TextView txtLivros;
    ImageView imgLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualiza_livro__main);

        txtLivros = findViewById(R.id.mtxtLivro);
        imgLivros = findViewById(R.id.mimgLivro);

        //Receber o valor de outra janela
        Intent intent = getIntent();

        //Recebendo os valores pela variável declarada na janela de origem
        String nLivro = intent.getStringExtra("nomeLivro");
        int mLivro = intent.getIntExtra("imagemLivro",0);

        //Inserindo os valores nos componentes
        txtLivros.setText(nLivro);
        imgLivros.setImageResource(mLivro);
    }
}