package com.example.projetodesktop.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Random;

public class GerenciadorDados {
    private static final ObservableList<UsuarioModel> listaClientes = FXCollections.observableArrayList();
    private static final ObservableList<UsuarioModel> listaGerentes = FXCollections.observableArrayList();
    private static final ObservableList<TicketModel> listaTickets = FXCollections.observableArrayList();

    static {
        // Gerente Padrão
        listaGerentes.add(new UsuarioModel("1", "1", "Gerente", "01/01/2026", 30));

        // Gerador de idades aleatórias entre 15 e 25 anos
        Random random = new Random();

        // Clientes de Teste
        listaClientes.add(new UsuarioModel("carla_souza", "senha123", "Ativo", "10/01/2026", 15 + random.nextInt(11)));
        listaClientes.add(new UsuarioModel("lucas_mendes", "senha123", "Ativo", "15/01/2026", 15 + random.nextInt(11)));
        listaClientes.add(new UsuarioModel("fer_almeida", "senha123", "Ativo", "02/02/2026", 15 + random.nextInt(11)));
        listaClientes.add(new UsuarioModel("rodrigo_lima", "senha123", "Banido (Spam)", "20/02/2026", 15 + random.nextInt(11)));
        listaClientes.add(new UsuarioModel("beatriz_costa", "senha123", "Ativo", "05/03/2026", 15 + random.nextInt(11)));
        listaClientes.add(new UsuarioModel("Lipe_23", "senha123", "Ativo", "12/03/2026", 15 + random.nextInt(11)));

        // Tickets do Help Center
        listaTickets.add(new TicketModel("#2026-001", "carla_souza", "Conteúdo Inadequado",
                "Comentário incentivando jejum não orientado por profissionais.", "Em Análise", "", "fulano_toxico", ""));

        listaTickets.add(new TicketModel("#2026-002", "lucas_mendes", "Erro de Conexão",
                "Não consegui salvar o registro diário de refeições.", "Aberto", "", "", ""));

        listaTickets.add(new TicketModel("#2026-003", "beatriz_costa", "Dúvida sobre Metas",
                "Como faço para alterar minha meta de água diária para 2.5L?", "Resolvido", "Sua meta foi ajustada nas configurações.", "", ""));

        listaTickets.add(new TicketModel("#2026-004", "lucas_mendes", "Receita Inapropriada",
                "O usuário 'Lipe_23' postou comentários depreciativos e inadequados na receita de Frango Grelhado.",
                "Aberto", "", "Lipe_23", "/com/example/projetodesktop/view/img/imagemteste.png"));
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
        listaGerentes.add(new UsuarioModel(login, senha, "Gerente", "21/10/2026", 35));
    }

    public static class UsuarioModel {
        private String login;
        private String senha;
        private String status;
        private String dataCadastro;
        private int idade; // Atributo da idade

        public UsuarioModel(String login, String senha, String status, String dataCadastro, int idade) {
            this.login = login;
            this.senha = senha;
            this.status = status;
            this.dataCadastro = dataCadastro;
            this.idade = idade;
        }

        public String getLogin() { return login; }
        public void setLogin(String login) { this.login = login; }
        public String getSenha() { return senha; }
        public void setSenha(String senha) { this.senha = senha; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getDataCadastro() { return dataCadastro; }
        public int getIdade() { return idade; } // Getter mapeado pelo PropertyValueFactory("idade")
        public void setIdade(int idade) { this.idade = idade; }
    }

    public static class TicketModel {
        private String protocolo;
        private String usuario;
        private String tipo;
        private String descricao;
        private String status;
        private String resposta;
        private String denunciado;
        private String caminhoImagem;

        public TicketModel(String protocolo, String usuario, String tipo, String descricao, String status, String resposta, String denunciado, String caminhoImagem) {
            this.protocolo = protocolo;
            this.usuario = usuario;
            this.tipo = tipo;
            this.descricao = descricao;
            this.status = status;
            this.resposta = resposta;
            this.denunciado = denunciado;
            this.caminhoImagem = caminhoImagem;
        }

        public String getProtocolo() { return protocolo; }
        public String getUsuario() { return usuario; }
        public String getTipo() { return tipo; }
        public String getDescricao() { return descricao; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }
        public String getResposta() { return resposta; }
        public void setResposta(String resposta) { this.resposta = resposta; }
        public String getDenunciado() { return denunciado; }
        public String getCaminhoImagem() { return caminhoImagem; }
    }
}