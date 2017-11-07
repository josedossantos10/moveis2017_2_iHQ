package br.com.projeto.ihq;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.projeto.ihq.adapters.HQAdapter;
import br.com.projeto.ihq.dao.HQDao;
import br.com.projeto.ihq.model.HQ;
import br.com.projeto.ihq.util.Util;

public class HQListActivity extends BaseActivity implements ListView.OnItemClickListener {
    ListView lvHqs;
    AlertDialog dialog;
    HQDao dao = new HQDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hqlist_layout);
        iniciarComponentes();

        Intent i = getIntent();
        String nome = i.getStringExtra(PUT_EXTRA_NOME);
        Util.addNomeNaLista(nome);

        dao.addHQ(new HQ(1, "Primeira", "Descrição"));
        dao.addHQ(new HQ(2, "Segunda", "Descrição"));
        dao.addHQ(new HQ(3, "Terceira", "Descrição"));
        HQAdapter adapter = new HQAdapter(this, R.layout.hqadapter_layout, dao.getHqs());
        lvHqs.setAdapter(adapter);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, Util.getNomes());
//        lvHqs.setAdapter(adapter);
        lvHqs.setOnItemClickListener(this);
        registerForContextMenu(lvHqs);

        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("Oi!");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem item = menu.add("Ler");
        item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                exibirMensagem("Hello!");
                return false;
            }
        });
        MenuItem item2 = menu.add("Editar");
    }

    private void iniciarComponentes() {
        lvHqs = (ListView) findViewById(R.id.lv_hqs);
    }

    private void criarBotoesAlerta() {
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                exibirMensagem("Clicado!");
                dialog.cancel();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        criarBotoesAlerta();
        dialog.setMessage("você clicou no " + dao.getHQ(position).getDescricao());
        dialog.show();
    }


}
