package criadorbanco.interfaces;

/**
 * Interface vai definir o contrato para objetos que podem ser "mantidos",
 * ou seja, que possuem uma representação ou ação de manutenção (como gerar SQL).
 */
public interface Mantivel {
    /**
     * Método para realizar a manutenção do objeto.
     * Em nosso contexto, pode ser usado para gerar partes do script SQL.
     * @return Uma String representando a parte do script SQL gerada por este objeto.
     */
    String manter();
}
