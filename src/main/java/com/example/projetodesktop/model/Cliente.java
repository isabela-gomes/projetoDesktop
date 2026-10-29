package com.example.projetodesktop.model;

public class Cliente {

private String nome;
private String genero;

private String idade;

private String peso;

private String condicaoEspecial;

    public Cliente(String nome, String genero, String idade, String peso, String condesp) {
        this.nome = nome;
        this.genero = genero;
        this.idade = String.valueOf(idade);
        this.peso = String.valueOf(peso);
        this.condicaoEspecial = condesp;
    }

    public Cliente(String carlosSilva, String masculino, int i, int i1, String condesp) {
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

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCondesp() {
        return condicaoEspecial;
    }

    public String getCondicaoEspecial() {
        return condicaoEspecial; // ou o nome da variável que você usou para guardar a condição
    }
}



