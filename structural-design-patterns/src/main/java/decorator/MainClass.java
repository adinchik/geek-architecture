package decorator;

public class MainClass {
    public static void main(String[] args) {
        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getCost());
        System.out.println(someCoffee.getDescription());

        Coffee milkCoffee = new MilkCoffee(someCoffee);
        System.out.println(milkCoffee.getCost());
        System.out.println(milkCoffee.getDescription());

        Coffee vanillaCoffee = new VanillaCoffee(milkCoffee);
        System.out.println(vanillaCoffee.getCost());
        System.out.println(vanillaCoffee.getDescription());

    }
}
