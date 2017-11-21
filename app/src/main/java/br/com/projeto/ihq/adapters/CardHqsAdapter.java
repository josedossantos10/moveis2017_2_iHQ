package br.com.projeto.ihq.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.projeto.ihq.R;
import br.com.projeto.ihq.model.Album;
import br.com.projeto.ihq.model.HQ;

public class CardHqsAdapter extends RecyclerView.Adapter<CardHqsAdapter.CardViewHoldes>{

    private Context context;
    private List<Album> albuns;


    public CardHqsAdapter(Context context, List<Album> albuns){
        super();
        this.context = context;
        this.albuns = albuns;
    }

    @Override
    public CardViewHoldes onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.item_card_principal, parent, false);
        CardViewHoldes card = new CardViewHoldes(v);

        return card;
    }

    @Override
    public void onBindViewHolder(final CardViewHoldes holder, int position) {
        Album a = albuns.get(position);
        holder.textItem.setText(a.getTitulo());

        holder.card_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.card_menu);
            }
        });

//        ListView lista = holder.listView;
//
//        HQAdapter adapter = new HQAdapter(context, R.layout.hqadapter_layout, a.getHqs());
//        lista.setAdapter(adapter);

    }

    private void showPopupMenu(View view){
        //Inflate menu
        PopupMenu popupMenu = new PopupMenu(context, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_card_view, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popupMenu.show();
    }

    public Context getContext(){
        return this.context;
    }

    @Override
    public int getItemCount() {
        return albuns.size();
    }

    public class CardViewHoldes extends RecyclerView.ViewHolder {

        private TextView textItem;
        private ListView listView;
        private ImageView card_menu;

        public CardViewHoldes(View itemView) {
            super(itemView);
            textItem = itemView.findViewById(R.id.tv_item_card);
            card_menu = (ImageView)itemView.findViewById(R.id.menu_item_card);
           // listView= itemView.findViewById(R.id.listview_item_principal);

        }
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.menu_editar:
                    Toast.makeText(context, "Editar Album", Toast.LENGTH_SHORT).show();
                case R.id.menu_excluir:
                    Toast.makeText(context, "Remover Album", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    }
}
