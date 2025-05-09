package questão_04;

public class Main {
    public static void main(String[] args) {
        Armazenador<Integer> a = new Armazenador<>();

        // Tentando adicionar novas chaves
        System.out.println("Adicionou 'A': " + a.add("A", 10)); // true
        System.out.println("Adicionou 'B': " + a.add("B", 20)); // true
        System.out.println("Adicionou 'A' novamente: " + a.add("A", 30)); // false

        // Buscando por chaves
        System.out.println(a.buscar("A")); // deve mostrar 10
        System.out.println(a.buscar("B")); // deve mostrar 20
        System.out.println(a.buscar("C")); // chave não existe
    }
}
