package decorator;

public class SimpleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "Simple coffee";
    }

    @Override
    public int getCost() {
        return 10;
    }
}
