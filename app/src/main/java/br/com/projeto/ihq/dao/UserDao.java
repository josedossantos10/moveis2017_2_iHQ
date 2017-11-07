package br.com.projeto.ihq.dao;

import android.content.Context;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class UserDao {
    public UserDao(Context context) {
        SQLfactory.getInstance(context);
    }
}
