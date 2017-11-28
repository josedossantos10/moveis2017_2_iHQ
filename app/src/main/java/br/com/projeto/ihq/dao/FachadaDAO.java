package br.com.projeto.ihq.dao;

import android.content.Context;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.model.Album;
import br.com.projeto.ihq.model.User;

/**
 * Created by prof Heldon on 21/11/2017.
 */

public class FachadaDAO {

    private Context context;
    public FachadaDAO(Context context) {
        this.context = context;
    }

    public void salvarAlbum( Album album) throws DAOException {
        new AlbumDao(context).insert(album);
    }
}
