package pizza;

/**
 * Construtor concreto de uma pizza com queijo.
 */
public class PizzaQueijoBuilder extends PizzaBuilder {

    @Override
    public void buildNome() {
        pizza.setNome("Pizza de Queijo");
    }

    @Override
    public void buildIngredientes() {
        pizza.setIngredientes("Molho branco, mussarela, parmesão");
    }

    @Override
    public void buildBorda() {
        pizza.setBorda("Borda recheada com queijo");
    }
}
