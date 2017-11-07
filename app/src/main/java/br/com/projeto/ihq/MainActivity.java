package br.com.projeto.ihq;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.projeto.ihq.dao.UserDao;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new UserDao(this);

    }
    @Override
    public void onClick(View v) {

    }

    public void cadastrarUsuario(View view) {
        startActivity(new Intent(this, CadastroUsuarioActivity.class));
    }


    public void login(View view) {
        startActivity(new Intent(this, PrincipalActivity.class));

    }
}
