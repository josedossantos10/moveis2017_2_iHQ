package br.com.projeto.ihq;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    TextView tvTitulo;
    EditText eTNome;
    Button btAcao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btAcao.setOnClickListener(this);
        tvTitulo.setOnClickListener(this);
    }

    private void iniciarComponentes() {
        eTNome = (EditText) findViewById(R.id.etNome);
        btAcao = (Button) findViewById(R.id.btAcao);
        tvTitulo = (TextView) findViewById(R.id.textView);
        tvTitulo.setText("PRIMEIRA ACTIVITY");

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btAcao:
                acao();
                break;
            case R.id.textView:
                String valor = eTNome.getText().toString();
                exibirMensagem(valor);
                break;
        }

    }

    private void acao() {
        String nome = eTNome.getText().toString();

        Intent intent = new Intent(this, HQListActivity.class);

        intent.putExtra(PUT_EXTRA_NOME, nome);

        startActivity(intent);

    }


}
