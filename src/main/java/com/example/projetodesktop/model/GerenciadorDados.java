package com.example.projetodesktop.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class GerenciadorDados {
    private static final ObservableList<UsuarioModel> listaClientes = FXCollections.observableArrayList();
    private static final ObservableList<UsuarioModel> listaGerentes = FXCollections.observableArrayList();
    private static final ObservableList<TicketModel> listaTickets = FXCollections.observableArrayList();

    static {
        listaGerentes.add(new UsuarioModel("1", "1", "Gerente", "01/01/2026", 30));
        listaGerentes.add(new UsuarioModel("gerente", "1234", "Gerente", "01/01/2026", 30));
        listaClientes.add(new UsuarioModel("carla_souza", "senha123", "Ativo", "10/01/2026", 16));
        listaClientes.add(new UsuarioModel("lucas_mendes", "senha123", "Ativo", "15/01/2026", 17));
        listaClientes.add(new UsuarioModel("fer_almeida", "senha123", "Ativo", "02/02/2026", 15));
        listaClientes.add(new UsuarioModel("rodrigo_lima", "senha123", "Banido (Spam)", "20/02/2026", 19));
        listaClientes.add(new UsuarioModel("beatriz_costa", "senha123", "Ativo", "05/03/2026", 18));
        listaClientes.add(new UsuarioModel("Lipe_23", "senha123", "Ativo", "12/03/2026", 16));
        listaTickets.add(new TicketModel("#2026-001", "carla_souza", "Conteúdo Inadequado", "Comentário incentivando jejum não orientado por profissionais.", "Em Análise", "", "Lipe_23", ""));
        listaTickets.add(new TicketModel("#2026-002", "lucas_mendes", "Erro de Conexão", "Não consegui salvar o registro diário de refeições.", "Aberto", "", "", ""));
        listaTickets.add(new TicketModel("#2026-003", "beatriz_costa", "Dúvida sobre Metas", "Como faço para alterar minha meta de água diária?", "Resolvido", "Sua dúvida foi encaminhada à equipe.", "", ""));
        listaTickets.add(new TicketModel("#2026-004", "lucas_mendes", "Receita Inapropriada", "O usuário Lipe_23 publicou uma receita com comentários depreciativos e recomendações alimentares inadequadas.", "Aberto", "", "Lipe_23", "/com/example/projetodesktop/view/img/imagemteste.png"));
    }

    private GerenciadorDados() { }
    public static ObservableList<UsuarioModel> getListaClientes() { return listaClientes; }
    public static ObservableList<UsuarioModel> getListaGerentes() { return listaGerentes; }
    public static ObservableList<TicketModel> getListaTickets() { return listaTickets; }
    public static boolean gerenteExiste(String login) { return listaGerentes.stream().anyMatch(g -> g.getLogin().equalsIgnoreCase(login)); }
    public static UsuarioModel buscarGerente(String login) { return listaGerentes.stream().filter(g -> g.getLogin().equalsIgnoreCase(login)).findFirst().orElse(null); }
    public static void adicionarGerente(String login, String senha) {
        String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        listaGerentes.add(new UsuarioModel(login, senha, "Gerente", data, 30));
    }
    public static UsuarioModel buscarCliente(String login) {
        return listaClientes.stream().filter(c -> c.getLogin().equalsIgnoreCase(login)).findFirst().orElse(null);
    }

    public static class UsuarioModel {
        private String login, senha, status, dataCadastro;
        private int idade;
        public UsuarioModel(String login, String senha, String status, String dataCadastro, int idade) {
            this.login=login; this.senha=senha; this.status=status; this.dataCadastro=dataCadastro; this.idade=idade;
        }
        public String getLogin(){return login;} public void setLogin(String v){login=v;}
        public String getSenha(){return senha;} public void setSenha(String v){senha=v;}
        public String getStatus(){return status;} public void setStatus(String v){status=v;}
        public String getDataCadastro(){return dataCadastro;} public void setDataCadastro(String v){dataCadastro=v;}
        public int getIdade(){return idade;} public void setIdade(int v){idade=v;}
    }

    public static class TicketModel {
        private String protocolo, usuario, tipo, descricao, status, resposta, denunciado, caminhoImagem;
        public TicketModel(String protocolo, String usuario, String tipo, String descricao, String status, String resposta, String denunciado, String caminhoImagem) {
            this.protocolo=protocolo; this.usuario=usuario; this.tipo=tipo; this.descricao=descricao; this.status=status; this.resposta=resposta; this.denunciado=denunciado; this.caminhoImagem=caminhoImagem;
        }
        public String getProtocolo(){return protocolo;} public String getUsuario(){return usuario;} public String getTipo(){return tipo;}
        public String getDescricao(){return descricao;} public String getStatus(){return status;} public void setStatus(String v){status=v;}
        public String getResposta(){return resposta;} public void setResposta(String v){resposta=v;} public String getDenunciado(){return denunciado;}
        public String getCaminhoImagem(){return caminhoImagem;}
    }
}
