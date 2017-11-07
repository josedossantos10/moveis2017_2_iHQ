package br.com.projeto.ihq.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

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
    public void onBindViewHolder(CardViewHoldes holder, int position) {
        Album a = albuns.get(position);
        holder.textItem.setText(a.getTitulo());

        ListView lista = holder.listView;

        HQAdapter adapter = new HQAdapter(context, R.layout.hqadapter_layout, a.getHqs());
        lista.setAdapter(adapter);

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

        public CardViewHoldes(View itemView) {
            super(itemView);
            textItem = itemView.findViewById(R.id.tv_item_card);
            listView= itemView.findViewById(R.id.listview_item_principal);



        }
    }
}
