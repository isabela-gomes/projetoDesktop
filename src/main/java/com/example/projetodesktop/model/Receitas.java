package com.example.projetodesktop.model;

public class Receitas {

    private String nomereceita;
    private String descricao;

    public Receitas(String nomereceita, String descricao) {
        this.nomereceita = nomereceita;
        this.descricao = descricao;
    }

    public String getNomereceita() {
        return nomereceita;
    }

    public void setNomereceita(String nomereceita) {
        this.nomereceita = nomereceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
