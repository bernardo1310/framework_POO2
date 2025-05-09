package questão_02;
import java.time.LocalDate;
public class Produto <T>{
	private T id;
	private double valor;
	private LocalDate dataFabricacao;
	private LocalDate dataVencimento;
	
	public Produto(T id, double valor, LocalDate dataFabricacao, LocalDate dataVencimento) {
		this.id = id;
        this.valor = valor;
        this.dataFabricacao = dataFabricacao;
        this.dataVencimento = dataVencimento;
	}
	
	public T getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public String toString() {
        return "ID: " + id + ", Valor: " + valor + ", Fabricação: " + dataFabricacao + ", Vencimento: " + dataVencimento;
    }
}

