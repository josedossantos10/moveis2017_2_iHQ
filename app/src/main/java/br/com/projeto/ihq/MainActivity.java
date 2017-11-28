package br.com.projeto.ihq;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.projeto.ihq.dao.UserDao;
import br.com.projeto.ihq.model.User;
import br.com.projeto.ihq.util.Util;

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

    public void logar(View view) {
        String email = ((EditText) findViewById(R.id.etEmail)).getText().toString();
        String senha = ((EditText) findViewById(R.id.etPassword)).getText().toString();
        User user = new UserDao(this).getUserByEmail(email.trim());
        if(user != null && senha.equals(user.getPassword())){
            Util.setUsuarioLogado(user);
            System.out.println(user.getId());
            System.out.println(Util.getUsuarioLogado().getEmail());
            System.out.println(Util.getUsuarioLogado().getId());
            System.out.println(Util.getUsuarioLogado().getNome());
            startActivity(new Intent(this, PrincipalActivity.class));
        }
        else
            exibirMensagem("Usuário não Encontrado!");

    }
}
