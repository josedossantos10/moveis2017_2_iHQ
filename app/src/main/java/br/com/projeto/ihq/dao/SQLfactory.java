package br.com.projeto.ihq.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class SQLfactory {
    private static SQLiteDatabase db;
    private static SQLHelper helper;

    private SQLfactory() {

    }
    public static SQLiteDatabase getInstance(Context context){

        if (db == null || !db.isOpen()){
            helper = new SQLHelper(context);
            db = helper.getWritableDatabase();
        }
        return db;
    }
    public static void closedb(){
        if (db != null || db.isOpen()){
            db.close();
            if (helper != null) helper.close();
        }
    }

}
