package com.example.projetodesktop.model;

public class Lembrete {
    private String titulo, descricao, horario;
    public Lembrete(String titulo, String descricao, String horario) { this.titulo=titulo; this.descricao=descricao; this.horario=horario; }
    public String getTitulo(){return titulo;} public void setTitulo(String v){titulo=v;}
    public String getDescricao(){return descricao;} public void setDescricao(String v){descricao=v;}
    public String getHorario(){return horario;} public void setHorario(String v){horario=v;}
}
