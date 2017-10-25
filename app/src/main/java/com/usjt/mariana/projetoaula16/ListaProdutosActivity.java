package com.usjt.mariana.projetoaula15;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaProdutosActivity extends Activity {

    public static final String NOME = "com.usjt.mariana.projetoaula15.nome";
    ArrayList<String> lista;
    Activity atividade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        atividade = this;
        Intent intent = getIntent();
        String chave = intent.getStringExtra(MainActivity.CHAVE);
        lista = buscarProdutos(chave);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheProdutoActivity.class);
                intent.putExtra(NOME, lista.get(position));

                startActivity(intent);

            }

        });

    }

    public ArrayList<String> buscarProdutos(String chave){
        ArrayList<String> lista = geraListaProdutos();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<String> subLista = new ArrayList<>();
            for(String nome:lista){
                if(nome.toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(nome);
                }
            }
            return subLista;
        }
    }

    public ArrayList<String> geraListaProdutos(){
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Arroz com Feijão");
        lista.add("Macarrão");
        lista.add("Lazanha");
        lista.add("Fritas");
        lista.add("Cheese Burguer");
        lista.add("Duplo completo");
        lista.add("Salada");
        lista.add("Escondidinho de Carne");
        lista.add("Sorvete");
        lista.add("Chocolate ao Leite");
        lista.add("Milk Skake");
        lista.add("Refrigerante");
        lista.add("Suco");
        lista.add("Bacon picadinho ao molho de Bode");
        return lista;
    }
}
