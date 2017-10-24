package br.com.projeto.ihq.model;

import java.util.Date;

public class HQ {
    private int id;
    private String imagem;
    private String titulo;
    private String descricao;
    private Date publicacao;
    private Date ultimaVisualizacao;
    private int volume;

    public HQ(int id, String titulo, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }

    public Date getUltimaVisualizacao() {
        return ultimaVisualizacao;
    }

    public void setUltimaVisualizacao(Date ultimaVisualizacao) {
        this.ultimaVisualizacao = ultimaVisualizacao;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
