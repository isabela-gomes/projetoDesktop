package com.example.projetodesktop.model;

public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private String usuarioLogado;

    private SessaoUsuario() {}

    public static SessaoUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SessaoUsuario();
        }
        return instancia;
    }

    public String getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(String usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public void encerrarSessao() {
        this.usuarioLogado = null;
    }
}