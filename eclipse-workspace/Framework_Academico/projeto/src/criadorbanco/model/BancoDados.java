package criadorbanco.model;

import criadorbanco.interfaces.Mantivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa um banco de dados, contendo uma coleção de tabelas.
 * Implementa Mantivel para que possa gerar sua própria parte do script SQL (criação do banco).
 */
public class BancoDados implements Mantivel {
    private String nome;
    private List<Tabela> tabelas;

    public BancoDados(String nome) {
        this.nome = nome;
        this.tabelas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarTabela(Tabela tabela) {
        this.tabelas.add(tabela);
    }

    public void removerTabela(Tabela tabela) {
        this.tabelas.remove(tabela);
    }

    public List<Tabela> getTabelas() {
        return Collections.unmodifiableList(tabelas); // Retorna uma lista imutável
    }

    /**
     * Gera o script SQL para criar o banco de dados.
     * @return String com o comando SQL para criar o banco.
     */
    @Override
    public String manter() {
        return "CREATE DATABASE IF NOT EXISTS " + nome + ";";
    }
}
