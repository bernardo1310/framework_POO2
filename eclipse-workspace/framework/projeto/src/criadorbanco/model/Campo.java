package criadorbanco.model;

import criadorbanco.interfaces.Mantivel;

/**
 * Representa uma coluna (campo) dentro de uma tabela do banco de dados.
 * Implementa Mantivel para que possa gerar sua própria parte do script SQL.
 */
public class Campo implements Mantivel {
    private String nome;
    private String tipo; // Ex: "VARCHAR(255)", "INT", "BOOLEAN"
    private boolean ehChavePrimaria;
    private boolean ehNulo;

    public Campo(String nome, String tipo, boolean ehChavePrimaria, boolean ehNulo) {
        this.nome = nome;
        this.tipo = tipo;
        this.ehChavePrimaria = ehChavePrimaria;
        this.ehNulo = ehNulo;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isEhChavePrimaria() {
        return ehChavePrimaria;
    }

    public boolean isEhNulo() {
        return ehNulo;
    }

    // Setters (se necessário)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEhChavePrimaria(boolean ehChavePrimaria) {
        this.ehChavePrimaria = ehChavePrimaria;
    }

    public void setEhNulo(boolean ehNulo) {
        this.ehNulo = ehNulo;
    }

    /**
     * Gera a parte do script SQL para a definição deste campo.
     * Ex: "id INT PRIMARY KEY NOT NULL" ou "nome VARCHAR(255) NULL"
     * @return String com a definição SQL do campo.
     */
    @Override
    public String manter() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(" ").append(tipo);
        if (ehChavePrimaria) {
            sb.append(" PRIMARY KEY");
        }
        if (!ehNulo) {
            sb.append(" NOT NULL");
        } else {
            sb.append(" NULL"); // Explicitamente NULL se for permitido
        }
        return sb.toString();
    }
}
