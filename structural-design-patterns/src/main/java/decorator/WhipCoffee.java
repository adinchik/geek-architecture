package decorator;

public class WhipCoffee implements Coffee{
    Coffee coffee;

    public WhipCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", whip";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 5;
    }
}
