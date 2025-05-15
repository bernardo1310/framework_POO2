package pizza;

/**
 * Classe abstrata que define o contrato para construção de uma pizza.
 */
public abstract class PizzaBuilder {
    protected PizzaProduct pizza = new PizzaProduct();

    public abstract void buildNome();
    public abstract void buildIngredientes();
    public abstract void buildBorda();

    public PizzaProduct getPizza() {
        return pizza;
    }
}
