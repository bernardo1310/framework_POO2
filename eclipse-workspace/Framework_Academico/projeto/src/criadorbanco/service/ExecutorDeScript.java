package criadorbanco.service;

import criadorbanco.model.ConfiguracaoConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável por executar scripts SQL em um banco de dados real
 * usando JDBC (Java Database Connectivity).
 * Atua como um DAO genérico para execução de DDL.
 */
public class ExecutorDeScript {
    private ConfiguracaoConexao configuracao;

    public ExecutorDeScript(ConfiguracaoConexao configuracao) {
        this.configuracao = configuracao;
        // Carrega o driver JDBC (ex: para MySQL)
        try {
            // Para MySQL: Class.forName("com.mysql.cj.jdbc.Driver");
            // Para PostgreSQL: Class.forName("org.postgresql.Driver");
            // Você precisará adicionar a dependência do driver JDBC ao seu projeto (ex: via Maven/Gradle ou JAR no Build Path)
            System.out.println("Driver JDBC carregado (verifique se o driver correto está no classpath).");
        } catch (Exception e) { // Usar Exception para capturar ClassNotFoundException e outros
            System.err.println("Erro ao carregar o driver JDBC: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Executa um script SQL no banco de dados configurado.
     * @param script O script SQL a ser executado.
     * @return true se a execução foi bem-sucedida, false caso contrário.
     */
    public boolean executar(String script) {
        Connection conexao = null;
        Statement stmt = null;
        try {
            // Constrói a URL de conexão. Exemplo para MySQL:
            // "jdbc:mysql://servidor:porta/nomeBanco?allowMultiQueries=true"
            // O 'allowMultiQueries=true' é importante para executar múltiplos comandos SQL em um único script.
            String url = String.format("jdbc:mysql://%s:%d/%s?allowMultiQueries=true",
                    configuracao.getServidor(), configuracao.getPorta(), configuracao.getNomeBanco());

            // Se o script for para criar o banco, a conexão inicial pode ser sem o nome do banco
            if (script.trim().startsWith("CREATE DATABASE")) {
                url = String.format("jdbc:mysql://%s:%d/?allowMultiQueries=true",
                        configuracao.getServidor(), configuracao.getPorta());
            }


            conexao = DriverManager.getConnection(url, configuracao.getUsuario(), configuracao.getSenha());
            stmt = conexao.createStatement();

            // Executa o script. Para múltiplos comandos, o driver JDBC precisa suportar.
            // Alguns drivers podem exigir que você divida o script em comandos individuais.
            // Para MySQL com allowMultiQueries=true, funciona bem.
            stmt.execute(script);

            System.out.println("Script SQL executado com sucesso!");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao executar script SQL: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            // Garante que os recursos sejam fechados
            try {
                if (stmt != null) stmt.close();
                if (conexao != null) conexao.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos JDBC: " + e.getMessage());
            }
        }
    }
}
