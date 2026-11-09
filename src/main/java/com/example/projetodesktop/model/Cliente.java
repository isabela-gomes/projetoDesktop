package com.example.projetodesktop.model;

public class Cliente {

    private String nome;
    private String genero;
    private String idade;
    private String condicaoEspecial;

    public Cliente(String nome, String genero, String idade, String condicaoEspecial) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.condicaoEspecial = condicaoEspecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCondicaoEspecial() {
        return condicaoEspecial;
    }

    public void setCondicaoEspecial(String condicaoEspecial) {
        this.condicaoEspecial = condicaoEspecial;
    }
}
