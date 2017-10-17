package br.com.projeto.ihq;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends BaseActivity {



    TextView tvNotificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        iniciarComponentes();

        Intent i = getIntent();

        String nome = i.getStringExtra(PUT_EXTRA_NOME);

        tvNotificacao.setText("Seja Bem Vindo " + nome);
    }

    private void iniciarComponentes() {

        tvNotificacao = (TextView) findViewById(R.id.tvNotificacao);
    }


}
