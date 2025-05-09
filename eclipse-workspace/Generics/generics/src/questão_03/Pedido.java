package questão_03;

import java.util.ArrayList;
import java.util.List;

public class Pedido<T extends Produto> {
    private List<T> produtos = new ArrayList<>();

    public void adicionarProduto(T produto) {
        produtos.add(produto);
    }

    public void mostrarProdutos() {
        for (T p : produtos) {
            System.out.println(p);
        }
    }
}
