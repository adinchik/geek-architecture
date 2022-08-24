package decorator;

public class VanillaCoffee implements Coffee {
    Coffee coffee;

    public VanillaCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", vanilla";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 3;
    }
}
