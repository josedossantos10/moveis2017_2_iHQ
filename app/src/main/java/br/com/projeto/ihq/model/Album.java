package br.com.projeto.ihq.model;

import java.util.List;

/**
 * Created by prof Heldon on 07/11/2017.
 */

public class Album {
    private Integer id;
    private String titulo;
    private List<HQ> hqs;
    private boolean sincronizado;
    private User user;

    public Album() {
        this.sincronizado = false;
    }

    public boolean isSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(boolean sincronizado) {
        this.sincronizado = sincronizado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<HQ> getHqs() {
        return hqs;
    }

    public void setHqs(List<HQ> hqs) {
        this.hqs = hqs;
    }
}
