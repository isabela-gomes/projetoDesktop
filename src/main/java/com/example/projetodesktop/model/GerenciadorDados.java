package com.example.projetodesktop.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GerenciadorDados {
    // Lista exclusiva para a tabela de Gerenciamento de Clientes
    private static final ObservableList<UsuarioModel> listaClientes = FXCollections.observableArrayList();

    // Lista exclusiva de Gerentes (usada só para autenticar Login/Cadastro)
    private static final ObservableList<UsuarioModel> listaGerentes = FXCollections.observableArrayList();

    private static final ObservableList<TicketModel> listaTickets = FXCollections.observableArrayList();

    static {
        // 1. Gerente Padrão (para Login)
        listaGerentes.add(new UsuarioModel("gerente", "1234", "Gerente", "01/01/2026"));

        // 2. Apenas os 5 Clientes de Teste na tabela
        listaClientes.add(new UsuarioModel("carla_souza", "senha123", "Ativo", "10/01/2026"));
        listaClientes.add(new UsuarioModel("lucas_mendes", "senha123", "Ativo", "15/01/2026"));
        listaClientes.add(new UsuarioModel("fer_almeida", "senha123", "Ativo", "02/02/2026"));
        listaClientes.add(new UsuarioModel("rodrigo_lima", "senha123", "Banido (Spam)", "20/02/2026"));
        listaClientes.add(new UsuarioModel("beatriz_costa", "senha123", "Ativo", "05/03/2026"));

        // 3. Tickets do Help Center
        listaTickets.add(new TicketModel("#2026-001", "carla_souza", "Conteúdo Inadequado",
                "Comentário incentivando jejum não orientado por profissionais.", "Em Análise", ""));

        listaTickets.add(new TicketModel("#2026-002", "lucas_mendes", "Erro de Conexão",
                "Não consegui salvar o registro diário de refeições.", "Aberto", ""));

        listaTickets.add(new TicketModel("#2026-003", "beatriz_costa", "Dúvida sobre Metas",
                "Como faço para alterar minha meta de água diária para 2.5L?", "Resolvido", "Sua meta foi ajustada nas configurações."));
    }

    public static ObservableList<UsuarioModel> getListaClientes() {
        return listaClientes;
    }

    public static ObservableList<TicketModel> getListaTickets() {
        return listaTickets;
    }

    public static boolean gerenteExiste(String login) {
        return listaGerentes.stream().anyMatch(g -> g.getLogin().equalsIgnoreCase(login));
    }

    public static UsuarioModel buscarGerente(String login) {
        return listaGerentes.stream()
                .filter(g -> g.getLogin().equalsIgnoreCase(login))
                .findFirst()
                .orElse(null);
    }

    public static void adicionarGerente(String login, String senha) {
        listaGerentes.add(new UsuarioModel(login, senha, "Gerente", "21/10/2026"));
    }

    // Modelo de Usuário / Cliente
    public static class UsuarioModel {
        private String login;
        private String senha;
        private String status;
        private String dataCadastro;

        public UsuarioModel(String login, String senha, String status, String dataCadastro) {
            this.login = login;
            this.senha = senha;
            this.status = status;
            this.dataCadastro = dataCadastro;
        }

        public String getLogin() { return login; }
        public void setLogin(String login) { this.login = login; }
        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getDataCadastro() { return dataCadastro; }
    }

    // Modelo de Ticket
    public static class TicketModel {
        private String protocolo;
        private String usuario;
        private String tipo;
        private String descricao;
        private String status;
        private String resposta;

        public TicketModel(String protocolo, String usuario, String tipo, String descricao, String status, String resposta) {
            this.protocolo = protocolo;
            this.usuario = usuario;
            this.tipo = tipo;
            this.descricao = descricao;
            this.status = status;
            this.resposta = resposta;
        }

        public String getProtocolo() { return protocolo; }
        public String getUsuario() { return usuario; }
        public String getTipo() { return tipo; }
        public String getDescricao() { return descricao; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getResposta() { return resposta; }
        public void setResposta(String resposta) { this.resposta = resposta; }
    }
}