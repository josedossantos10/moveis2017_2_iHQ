package br.com.projeto.ihq.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.projeto.ihq.R;
import br.com.projeto.ihq.model.HQ;

public class HQAdapter extends ArrayAdapter<HQ> {
    TextView tvNome;
    TextView tvDescricao;
    Context context;

    public HQAdapter(Context context, int resource, List<HQ> lista) {
        super(context, resource, lista);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.hqadapter_layout, parent, false);
        tvNome = (TextView) view.findViewById(R.id.tvNome);
        tvDescricao = (TextView) view.findViewById(R.id.tvDescricao);

        HQ hq = getItem(position);
        tvNome.setText(hq.getTitulo());
        tvDescricao.setText(hq.getDescricao());
        return view;
    }

}
