package com.example.projetodesktop.model;

public class Receita {
    private String nome, receita, alergicos, tabelaNutricional;
    public Receita(String nome, String receita, String alergicos, String tabelaNutricional) {
        this.nome=nome; this.receita=receita; this.alergicos=alergicos; this.tabelaNutricional=tabelaNutricional;
    }
    public String getNome(){return nome;} public void setNome(String v){nome=v;}
    public String getReceita(){return receita;} public void setReceita(String v){receita=v;}
    public String getAlergicos(){return alergicos;} public void setAlergicos(String v){alergicos=v;}
    public String getTabelaNutricional(){return tabelaNutricional;} public void setTabelaNutricional(String v){tabelaNutricional=v;}
}
