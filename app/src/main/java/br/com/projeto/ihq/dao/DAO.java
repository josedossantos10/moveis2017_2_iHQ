package br.com.projeto.ihq.dao;

import java.util.List;

import br.com.projeto.ihq.control.DAOException;
import br.com.projeto.ihq.model.User;

/**
 * Created by prof Heldon on 21/11/2017.
 */

public abstract class DAO<T> {
    public abstract void insert(T obj) throws DAOException;
    public abstract void update(T obj)throws DAOException;
    public abstract void delete(Integer id)throws DAOException;
    public abstract T selectById(Integer id)throws DAOException;
    public abstract List<T> selectByName(String name)throws DAOException;
    public abstract List<T> selectAll()throws DAOException;
}
