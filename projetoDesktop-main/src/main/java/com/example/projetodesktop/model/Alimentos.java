package com.example.projetodesktop.model;

public class Alimentos {

    private String nome;
    private String categoria;

    private double calorias;

    public Alimentos(String nome, String categoria, double carboidratos) {
        this.nome = nome;
        this.categoria = categoria;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
}
