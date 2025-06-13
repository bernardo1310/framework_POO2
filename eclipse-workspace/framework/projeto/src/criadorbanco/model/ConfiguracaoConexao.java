package criadorbanco.model;

/**
 * Representa as configurações necessárias para estabelecer uma conexão com o banco de dados.
 * Atua como um DTO para as informações de conexão.
 */
public class ConfiguracaoConexao {
    private String servidor;
    private int porta;
    private String usuario;
    private String senha;
    private String nomeBanco; // Adicionado para o nome do banco de dados

    public ConfiguracaoConexao(String servidor, int porta, String usuario, String senha, String nomeBanco) {
        this.servidor = servidor;
        this.porta = porta;
        this.usuario = usuario;
        this.senha = senha;
        this.nomeBanco = nomeBanco;
    }

    // Getters
    public String getServidor() {
        return servidor;
    }

    public int getPorta() {
        return porta;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    // Setters (se necessário, mas para configurações, geralmente são imutáveis após a criação)
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
}
