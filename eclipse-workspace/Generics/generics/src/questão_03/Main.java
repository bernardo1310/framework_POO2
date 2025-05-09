package questão_03;

public class Main {
    public static void main(String[] args) {
        Pedido<Produto > pedido = new Pedido<>();

        // Adicionando produtos
        pedido.adicionarProduto(new Produto ("Arroz", 25.0));
        pedido.adicionarProduto(new Produto ("Feijão", 8.5));

        // Mostrando produtos
        System.out.println("Lista de Produtos:");
        pedido.mostrarProdutos();
    }
}
