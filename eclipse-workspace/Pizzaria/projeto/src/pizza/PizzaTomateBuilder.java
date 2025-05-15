package pizza;

/**
 * Construtor concreto de uma pizza com tomate.
 */
public class PizzaTomateBuilder extends PizzaBuilder {

    @Override
    public void buildNome() {
        pizza.setNome("Pizza de Tomate");
    }

    @Override
    public void buildIngredientes() {
        pizza.setIngredientes("Molho de tomate, fatias de tomate, orégano");
    }

    @Override
    public void buildBorda() {
        pizza.setBorda("Borda fina");
    }
}
