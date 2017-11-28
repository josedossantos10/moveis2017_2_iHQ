package br.com.projeto.ihq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.dao.UserDao;
import br.com.projeto.ihq.model.User;
import br.com.projeto.ihq.util.Util;

public class CadastroUsuarioActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editEmail;
    private EditText editPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        editNome= (EditText) findViewById(R.id.etNomeNovoUser);
        editEmail= (EditText) findViewById(R.id.etEmailNovoUser);
        editPassword= (EditText) findViewById(R.id.etPasswordNovoUser);


    }

    public void cadastrarNovoUsuario(View view) {
        String nome = editNome.getText().toString();
        String email = editEmail.getText().toString();
        String password = editPassword.getText().toString();

        if (nome.isEmpty()||email.isEmpty()||password.isEmpty()|| Util.validarEmail(email)){
            Toast.makeText(this, "Preencha os campos corretamente", Toast.LENGTH_SHORT).show();
            return;
        }
        User user = new User(email,nome, password);
        try {
            UserDao dao = new UserDao(this);
            User test = dao.getUserByEmail(user.getEmail());
            if(test != null)
                Toast.makeText(this, "E-mail já cadastrado", Toast.LENGTH_SHORT).show();
            else {
                dao.insert(user);
                finish();
            }


        } catch (DAOException e) {
            e.printStackTrace();
        }


    }

    public void voltar(View view) {
        finish();
    }

}
