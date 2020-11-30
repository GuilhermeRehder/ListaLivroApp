package com.example.listalivroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    String nomeLivros[] = {"Principia: Princípios Matemáticos de Filosofia Natural", "O Mundo Assombrado Pelos Demônios", "Variedades da Experiência Científica", "Bilhões e Bilhões",
            "Contato", "Cosmos", "Pálido Ponto Azul", "Minha Breve História", "Uma Breve História do Tempo", "O Universo Numa Casca de Noz",
            "Buracos Negros", "Breves Respostas para Grandes Questões", "O Universo Elegante", "O Tecido do Cosmo", "A Realidade Oculta",
            "Origens", "Morte no Buraco Negro", "Astrofísica para apressados", "Alice no País do Quantum", "A Origem das Espécies"};

    int imgLivros[] = {R.drawable.matematica, R.drawable.assombrado, R.drawable.variedades,
            R.drawable.bilhoes, R.drawable.contato, R.drawable.cosmos,
            R.drawable.ponto, R.drawable.minha, R.drawable.tempo,
            R.drawable.universo, R.drawable.buracos, R.drawable.respostas,
            R.drawable.elegante, R.drawable.tecido, R.drawable.realidade,
            R.drawable.origens, R.drawable.buraconegro, R.drawable.astrofisica, R.drawable.quantum, R.drawable.origem};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //a variavel listview está recebendo a listView XML
        listView = findViewById(R.id.listaLivros);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter customAdapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(customAdapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), VisualizaLivro_MainActivity.class);
                //Passando valores de uma janela para outra
                intent.putExtra("nomeLivro", nomeLivros[i]);
                intent.putExtra("imagemLivro", imgLivros[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgLivros.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de livros - ListView
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtNomeLivro;
            ImageView imagemLivro;

            //instanciando o modelo com os componentes para inserir na Lista
            View carregaView = getLayoutInflater().inflate(R.layout.modelo_lista_livros, null);

            txtNomeLivro = carregaView.findViewById(R.id.txtListaLivro);
            imagemLivro = carregaView.findViewById(R.id.imgListaLivro);

            //Carregando os valores nos componentes

            txtNomeLivro.setText(nomeLivros[i]);
            imagemLivro.setImageResource(imgLivros[i]);

            return carregaView;
        }
    }
}