package pizza;

/**
 * Classe que representa uma pizza com nome, ingredientes e tipo de borda.
 */
public class PizzaProduct {
    private String nome;
    private String ingredientes;
    private String borda;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public String getNome() {
        return nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public String getBorda() {
        return borda;
    }

    @Override
    public String toString() {
        return "Pizza [nome=" + nome + ", ingredientes=" + ingredientes + ", borda=" + borda + "]";
    }
}
