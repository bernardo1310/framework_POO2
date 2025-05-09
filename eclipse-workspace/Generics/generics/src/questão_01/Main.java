package questão_01;

public class Main {
    public static void main(String[] args) {
        MeuObjeto<String> objString = new MeuObjeto<>("Olá");
        System.out.println("String: " + objString.getDado());


        MeuObjeto<Integer> objInt = new MeuObjeto<>(123);
        System.out.println("Integer: " + objInt.getDado());

        Pessoa pessoa = new Pessoa("João");
        MeuObjeto<Pessoa> objPessoa = new MeuObjeto<>(pessoa);
        System.out.println("Pessoa: " + objPessoa.getDado());
    }
}
