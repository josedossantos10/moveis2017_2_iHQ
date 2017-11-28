package br.com.projeto.ihq.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.projeto.ihq.util.Util;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class SQLHelper extends SQLiteOpenHelper
{
    public static final String NOME = "HQs.sqlite";
    public static final int VERSION = 10;



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

        db.execSQL("DROP TABLE user");
        db.execSQL("DROP TABLE IF EXISTS album");
        db.execSQL("DROP TABLE IF EXISTS hq");

        db.execSQL(UtilSQLs.TABLE_USER);
        db.execSQL(UtilSQLs.TABLE_ALBUM);
        db.execSQL(UtilSQLs.TABLE_HQ);

        Log.i("BD","editando o banco de dados");
//            db.execSQL(UtilSQLs.TABLE_ALBUM);
//            db.execSQL(UtilSQLs.TABLE_HQ);


    }
}
