package pizza;

/**
 * Construtor concreto de uma pizza com bacon.
 */
public class PizzaBaconBuilder extends PizzaBuilder {

    @Override
    public void buildNome() {
        pizza.setNome("Pizza de Bacon");
    }

    @Override
    public void buildIngredientes() {
        pizza.setIngredientes("Molho especial, bacon crocante, cebola roxa");
    }

    @Override
    public void buildBorda() {
        pizza.setBorda("Borda grossa tradicional");
    }
}
