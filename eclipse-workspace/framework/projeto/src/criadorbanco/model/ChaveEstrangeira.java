package criadorbanco.model;

/**
 * Representa uma chave estrangeira, definindo um relacionamento entre tabelas.
 */
public class ChaveEstrangeira {
    private Campo campoOrigem; // O campo na tabela atual que é a FK
    private Tabela tabelaDestino; // A tabela referenciada
    private Campo campoDestino; // O campo na tabela de destino que é a PK

    public ChaveEstrangeira(Campo campoOrigem, Tabela tabelaDestino, Campo campoDestino) {
        this.campoOrigem = campoOrigem;
        this.tabelaDestino = tabelaDestino;
        this.campoDestino = campoDestino;
    }

    // Getters
    public Campo getCampoOrigem() {
        return campoOrigem;
    }

    public Tabela getTabelaDestino() {
        return tabelaDestino;
    }

    public Campo getCampoDestino() {
        return campoDestino;
    }

    // Setters (se necessário)
    public void setCampoOrigem(Campo campoOrigem) {
        this.campoOrigem = campoOrigem;
    }

    public void setTabelaDestino(Tabela tabelaDestino) {
        this.tabelaDestino = tabelaDestino;
    }

    public void setCampoDestino(Campo campoDestino) {
        this.campoDestino = campoDestino;
    }
}
