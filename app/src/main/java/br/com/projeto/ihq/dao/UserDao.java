package br.com.projeto.ihq.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.model.User;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class UserDao extends DAO<User> {
    private SQLiteDatabase db;
    private static Context context;
    public UserDao(Context context) {
        this.context = context;
    }

    @Override
    public void insert(User obj) throws DAOException {
        db = SQLfactory.getInstance(context);
        try {
            ContentValues values= new ContentValues();
            values.put("nome",obj.getNome());
            values.put("email",obj.getEmail());
            values.put("password",obj.getPassword());
            values.put("sincronizado",obj.isSincronizado());
            System.out.println("ID USERNOVO: " + db.insert("user",null,values));

        }catch (SQLiteConstraintException e){
//            e.printStackTrace();
            throw new DAOException("Erro ao inserir Usuário");
        }finally {
            SQLfactory.closedb();
        }


    }

    @Override
    public void update(User obj) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }

    @Override
    public User selectById(Integer id) throws DAOException {
        return null;
    }

    @Override
    public List<User> selectByName(String name) throws DAOException {
        return null;
    }

    @Override
    public List<User> selectAll() throws DAOException {
        return null;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try{
            db = SQLfactory.getInstance(context);
            System.out.println(email);
            Cursor cursor = db.query("user", null, "email=?", new String[]{email}, null, null, null);
            if(cursor.moveToFirst()){
                user = new User();
                System.out.println("-----------");

                System.out.println(cursor.getLong(cursor.getColumnIndex("id")));
                System.out.println(cursor.getInt(cursor.getColumnIndex("id")));
                System.out.println(cursor.getLong(1));
                System.out.println("-----------");

                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            SQLfactory.closedb();
        }
        return user;
    }
}
