package br.com.projeto.ihq;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


public class BaseActivity extends AppCompatActivity {

    public static final String TAG_CICLO_VIDA = "CICLO VIDA";
    public static final String TAG_MENSAGEM = "MENSAGEM";
    public static final String PUT_EXTRA_NOME= "NOME";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG_CICLO_VIDA, this.toString()+ " - onDestroy");
    }


    public void exibirMensagem(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
