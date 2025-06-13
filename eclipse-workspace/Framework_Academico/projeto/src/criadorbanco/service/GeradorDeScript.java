package criadorbanco.service;


import criadorbanco.model.BancoDados;
import criadorbanco.model.ChaveEstrangeira;
import criadorbanco.model.Tabela;

/**
 * Classe responsável por gerar os scripts SQL de criação para o banco de dados e suas tabelas.
 */
public class GeradorDeScript {

    /**
     * Gera o script SQL para criar o banco de dados.
     * @param banco O objeto BancoDados.
     * @return String com o script SQL.
     */
    public String gerarScriptCriacaoBanco(BancoDados banco) {
        return banco.manter(); // Reutiliza o método manter() do BancoDados
    }

    /**
     * Gera o script SQL para criar uma tabela específica.
     * @param tabela O objeto Tabela.
     * @return String com o script SQL.
     */
    public String gerarScriptCriacaoTabela(Tabela tabela) {
        return tabela.manter(); // Reutiliza o método manter() da Tabela
    }

    /**
     * Gera o script SQL para adicionar chaves estrangeiras a uma tabela.
     * @param tabela O objeto Tabela.
     * @return String com o script SQL para as chaves estrangeiras.
     */
    public String gerarScriptChavesEstrangeiras(Tabela tabela) {
        StringBuilder sb = new StringBuilder();
        for (ChaveEstrangeira fk : tabela.getChavesEstrangeiras()) {
            sb.append("ALTER TABLE ").append(tabela.getNome())
              .append(" ADD CONSTRAINT fk_").append(tabela.getNome()).append("_")
              .append(fk.getCampoOrigem().getNome())
              .append(" FOREIGN KEY (").append(fk.getCampoOrigem().getNome()).append(")")
              .append(" REFERENCES ").append(fk.getTabelaDestino().getNome())
              .append("(").append(fk.getCampoDestino().getNome()).append(");\n");
        }
        return sb.toString();
    }

    /**
     * Gera o script SQL completo para a criação do banco de dados, todas as suas tabelas
     * e suas respectivas chaves estrangeiras.
     * @param banco O objeto BancoDados.
     * @return String com o script SQL completo.
     */
    public String gerarScriptCompleto(BancoDados banco) {
        StringBuilder sb = new StringBuilder();

        // 1. Script de criação do banco de dados
        sb.append(gerarScriptCriacaoBanco(banco)).append("\n\n");

        // 2. Comando para usar o banco de dados (específico para alguns SGBDs)
        sb.append("USE ").append(banco.getNome()).append(";\n\n");

        // 3. Scripts de criação de tabelas
        for (Tabela tabela : banco.getTabelas()) {
            sb.append(gerarScriptCriacaoTabela(tabela)).append("\n\n");
        }

        // 4. Scripts de criação de chaves estrangeiras (após todas as tabelas existirem)
        for (Tabela tabela : banco.getTabelas()) {
            sb.append(gerarScriptChavesEstrangeiras(tabela));
        }

        return sb.toString();
    }
}
