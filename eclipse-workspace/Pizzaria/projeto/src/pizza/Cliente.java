package pizza;

/**
 * Classe cliente para testar a construção das pizzas.
 */
public class Cliente {
    public static void main(String[] args) {
        Pizzaiolo pizzaiolo;

        pizzaiolo = new Pizzaiolo(new PizzaTomateBuilder());
        pizzaiolo.montarPizza();
        PizzaProduct pizza1 = pizzaiolo.getPizza();
        System.out.println(pizza1);

        pizzaiolo = new Pizzaiolo(new PizzaQueijoBuilder());
        pizzaiolo.montarPizza();
        PizzaProduct pizza2 = pizzaiolo.getPizza();
        System.out.println(pizza2);

        pizzaiolo = new Pizzaiolo(new PizzaBaconBuilder());
        pizzaiolo.montarPizza();
        PizzaProduct pizza3 = pizzaiolo.getPizza();
        System.out.println(pizza3);
    }
}
