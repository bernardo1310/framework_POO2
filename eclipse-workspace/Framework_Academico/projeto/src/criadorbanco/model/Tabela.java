package criadorbanco.model;

import criadorbanco.interfaces.Mantivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Representa uma tabela no banco de dados, contendo campos e chaves estrangeiras.
 * Implementa Mantivel para que possa gerar sua própria parte do script SQL.
 */
public class Tabela implements Mantivel {
    private String nome;
    private List<Campo> campos;
    private List<ChaveEstrangeira> chavesEstrangeiras;

    public Tabela(String nome) {
        this.nome = nome;
        this.campos = new ArrayList<>();
        this.chavesEstrangeiras = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCampo(Campo campo) {
        this.campos.add(campo);
    }

    public void removerCampo(Campo campo) {
        this.campos.remove(campo);
    }

    public List<Campo> getCampos() {
        return Collections.unmodifiableList(campos); // Retorna uma lista imutável
    }

    public void adicionarChaveEstrangeira(ChaveEstrangeira chave) {
        this.chavesEstrangeiras.add(chave);
    }

    public List<ChaveEstrangeira> getChavesEstrangeiras() {
        return Collections.unmodifiableList(chavesEstrangeiras); // Retorna uma lista imutável
    }

    /**
     * Gera a parte do script SQL para a criação desta tabela, incluindo campos e chaves primárias.
     * As chaves estrangeiras são geradas separadamente pelo GeradorDeScript.
     * @return String com a definição SQL da tabela.
     */
    @Override
    public String manter() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(nome).append(" (\n");

        // Adiciona a definição de cada campo
        String camposSql = campos.stream()
                .map(Campo::manter)
                .collect(Collectors.joining(",\n"));
        sb.append(camposSql);

        // Adiciona a definição de chave primária, se houver
        List<Campo> chavesPrimarias = campos.stream()
                .filter(Campo::isEhChavePrimaria)
                .collect(Collectors.toList());

        if (!chavesPrimarias.isEmpty()) {
            String pkNames = chavesPrimarias.stream()
                    .map(Campo::getNome)
                    .collect(Collectors.joining(", "));
            sb.append(",\n    PRIMARY KEY (").append(pkNames).append(")");
        }

        sb.append("\n);");
        return sb.toString();
    }
}
