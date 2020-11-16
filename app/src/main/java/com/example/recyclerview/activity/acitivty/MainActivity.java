package com.example.recyclerview.activity.acitivty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recyclerview.R;
import com.example.recyclerview.activity.RecyclerItemClickListener;
import com.example.recyclerview.activity.adapter.Adapter;
import com.example.recyclerview.activity.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Listegem de Filmes
        this.criarFilmes();

        //Configurar o Adapter
        Adapter adapter = new Adapter(listaFilmes);

        //Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Evento de Click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(MainActivity.this, filme.getFilme() + ", foi selecionado",
                                        Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Filme filme = listaFilmes.get(position);
                                Toast.makeText(MainActivity.this, "Clique Longo no, " + filme.getFilme(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )
        );
    }

    public void criarFilmes() {
        Filme filme = new Filme("Five Feets Apart", "Romance", "2019");
        this.listaFilmes.add(filme);
        filme = new Filme("The Mountain Between Us", "Romance", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Everything, Everythimg", "Romance", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Como Eu Era Antes de Ti ", "Romance", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Todo Dia", "Romance", "2017");
        this.listaFilmes.add(filme);
        filme = new Filme("Adilson", "Romance", "2017");

    }
}