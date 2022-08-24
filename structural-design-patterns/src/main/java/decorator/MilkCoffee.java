package decorator;

public class MilkCoffee implements Coffee{
    Coffee coffee;

    public MilkCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + " with milk";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 2;
    }
}
