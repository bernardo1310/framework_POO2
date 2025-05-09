package questão_01;

public class MeuObjeto<T> {
    private T dado;

    public MeuObjeto(T dado) {
        this.dado = dado;
    }

    public T getDado() {
        return dado;
    }
}
