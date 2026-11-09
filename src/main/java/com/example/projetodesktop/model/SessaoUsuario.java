package com.example.projetodesktop.model;

public final class SessaoUsuario {
    private static final SessaoUsuario INSTANCIA = new SessaoUsuario();
    private String usuarioLogado;
    private SessaoUsuario() { }
    public static SessaoUsuario getInstancia() { return INSTANCIA; }
    public String getUsuarioLogado() { return usuarioLogado; }
    public void setUsuarioLogado(String usuarioLogado) { this.usuarioLogado=usuarioLogado; }
    public void encerrarSessao() { usuarioLogado=null; }
}
