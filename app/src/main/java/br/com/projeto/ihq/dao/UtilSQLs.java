package br.com.projeto.ihq.dao;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class UtilSQLs {
    public static final String TABLE_USER = "create table user(" +
            "id integer primary key AUTOINCREMENT ," +
            "nome varchar not null," +
            "password varchar not null,"+
            "sincronizado boolean not null,"+
            "email varchar not null unique" +
            ")";

    public  static final String TABLE_ALBUM = "create table album(" +
            "id integer primary key AUTOINCREMENT ," +
            "titulo varchar," +
            "sincronizado boolean not null,"+
            "id_user int," +
            "foreign key(id_user) references user(id)" +
            ")";
    public  static final String TABLE_HQ = "create table hq(" +
            "id integer primary key AUTOINCREMENT ," +
            "imagem varchar," +
            "titulo varchar," +
            "descricao text," +
            "publicacao date," +
            "ultimaVisualizacao date," +
            "volume int," +
            "id_user int," +
            "sincronizado boolean not null,"+
            "id_album int," +
            "foreign key(id_user) references user(id)," +
            "foreign key(id_album) references album(id)" +
            ")";
    public static final String UPDATE_USER =
            "alter table user " +
            "add column password varchar";
}
