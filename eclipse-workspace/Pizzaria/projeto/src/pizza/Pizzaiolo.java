package pizza;

/**
 * Diretor que orienta a montagem da pizza.
 */
public class Pizzaiolo {
    protected PizzaBuilder builder;

    public Pizzaiolo(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void montarPizza() {
        builder.buildNome();
        builder.buildIngredientes();
        builder.buildBorda();
    }

    public PizzaProduct getPizza() {
        return builder.getPizza();
    }
}
