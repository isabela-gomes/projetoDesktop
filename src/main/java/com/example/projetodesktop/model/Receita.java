package com.example.projetodesktop.model;

public class Receita {

    private String nome;
    private String receita;
    private String alergicos;
    private String tabelaNutricional;

    public Receita(String nome, String receita, String alergicos, String tabelaNutricional) {
        this.nome = nome;
        this.receita = receita;
        this.alergicos = alergicos;
        this.tabelaNutricional = tabelaNutricional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getAlergicos() {
        return alergicos;
    }

    public void setAlergicos(String alergicos) {
        this.alergicos = alergicos;
    }

    public String getTabelaNutricional() {
        return tabelaNutricional;
    }

    public void setTabelaNutricional(String tabelaNutricional) {
        this.tabelaNutricional = tabelaNutricional;
    }
}
