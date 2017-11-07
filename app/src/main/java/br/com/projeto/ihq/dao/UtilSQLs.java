package br.com.projeto.ihq.dao;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class UtilSQLs {
    public static final String TABLE_USER = "create table user(" +
            "id int primary key," +
            "nome varchar not null," +
            "login varchar not null" +
            ")";

    public  static final String TABLE_ALBUM = "create table album(" +
            "id int primary key," +
            "titulo varchar," +
            "id_user int," +
            "foreign key(id_user) references user(id)" +
            ")";
    public  static final String TABLE_HQ = "create table hq(" +
            "id int primary key," +
            "imagem varchar," +
            "titulo varchar," +
            "descricao text," +
            "publicacao date," +
            "ultimaVisualizacao date," +
            "volume int," +
            "id_user int," +
            "id_album int," +
            "foreign key(id_user) references user(id)," +
            "foreign key(id_album) references album(id)" +
            ")";
}
