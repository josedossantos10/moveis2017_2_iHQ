package br.com.projeto.ihq.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class SQLHelper extends SQLiteOpenHelper
{
    public static final String NOME = "HQs.sqlite";
    public static final int VERSION = 4;



    public SQLHelper(Context context) {
        super(context, NOME, null, VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("BD","criando o banco de dados");
        db.execSQL(UtilSQLs.TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


            Log.i("BD","editando o banco de dados");
//            db.execSQL(UtilSQLs.TABLE_ALBUM);
//            db.execSQL(UtilSQLs.TABLE_HQ);


    }
}
