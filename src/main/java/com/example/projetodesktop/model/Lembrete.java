package com.example.projetodesktop.model;

public class Lembrete {
    private String titulo;

    private String descricao;

    private String horario;

    public Lembrete(String titulo, String descricao, String horario) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horario = horario;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
