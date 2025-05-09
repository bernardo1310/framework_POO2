package questão_02;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	
        Produto<Integer> prodInt = new Produto<>(1001, 29.90, LocalDate.of(2024, 5, 1), LocalDate.of(2025, 5, 1));
        System.out.println("Produto com ID Integer:");
        System.out.println(prodInt);

        // Produto com id do tipo String
        Produto<String> prodStr = new Produto<>("A100X", 45.50, LocalDate.of(2024, 3, 15), LocalDate.of(2025, 3, 15));
        System.out.println("Produto com ID String:");
        System.out.println(prodStr);
    }
}
