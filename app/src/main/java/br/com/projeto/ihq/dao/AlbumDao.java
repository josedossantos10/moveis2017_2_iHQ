package br.com.projeto.ihq.dao;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.model.Album;

/**
 * Created by prof Heldon on 21/11/2017.
 */

public class AlbumDao extends DAO<Album>{
    private Context context;
    public AlbumDao(Context context) {
        this.context = context;
    }

    @Override
    public void  insert(Album obj) throws DAOException {
        try {
            Toast.makeText(context, "Salvo", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            throw new DAOException("Erro ao inserir no Banco de Dados");
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
