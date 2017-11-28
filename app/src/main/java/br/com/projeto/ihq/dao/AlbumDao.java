package br.com.projeto.ihq.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.List;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.model.Album;
import br.com.projeto.ihq.util.Util;

/**
 * Created by prof Heldon on 21/11/2017.
 */

public class AlbumDao extends DAO<Album>{
    private Context context;
    private SQLiteDatabase db;

    public AlbumDao(Context context) {
        this.context = context;
    }

    @Override
    public void  insert(Album obj) throws DAOException {
        db = SQLfactory.getInstance(context);
        try {

            System.out.println("Valores....");
            System.out.println(Util.getUsuarioLogado());
            System.out.println(Util.getUsuarioLogado().getEmail());
            System.out.println(obj.getTitulo());
            ContentValues values= new ContentValues();
            values.put("titulo", obj.getTitulo());
            values.put("id_user", Util.getUsuarioLogado().getId());
            values.put("sincronizado", obj.isSincronizado());
            System.out.println("novo album: " + db.insert("album",null,values));
        }catch (SQLiteConstraintException e){
//            e.printStackTrace();
            throw new DAOException("Erro ao inserir Album");
        }finally {
            SQLfactory.closedb();
        }
    }

    @Override
    public void update(Album obj) throws DAOException {

    }

    @Override
    public void delete(Integer id) throws DAOException {

    }

    @Override
    public Album selectById(Integer id) throws DAOException {
        return null;
    }

    @Override
    public List<Album> selectByName(String name) throws DAOException {
        return null;
    }

    @Override
    public List<Album> selectAll() throws DAOException {
        return null;
    }
}
