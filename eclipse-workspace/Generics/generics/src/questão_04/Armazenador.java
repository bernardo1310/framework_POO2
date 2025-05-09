package questão_04;

import java.util.ArrayList;
import java.util.List;

public class Armazenador<T> {
    private List<String> chaves = new ArrayList<>();
    private List<T> valores = new ArrayList<>();

    public boolean add(String chave, T valor) {
        if (chaves.contains(chave)) {
            return false; // chave já existe
        }
        chaves.add(chave);
        valores.add(valor);
        return true;
    }

    public String buscar(String chave) {
        int index = chaves.indexOf(chave);
        if (index >= 0) {
            return "Chave: " + chaves.get(index) + ", Valor: " + valores.get(index);
        }
        return "Chave não encontrada.";
    }
}
