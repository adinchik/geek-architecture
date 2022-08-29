package flyweight;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {
    private HashMap<Integer, KarakTea> orders;
    private TeaMaker teaMaker;

    public TeaShop(TeaMaker teaMaker) {
        this.teaMaker = teaMaker;
        this.orders = new HashMap<>();

    }

    public void takeOrder(String teaType, int table) {
        orders.put(table, teaMaker.make(teaType));
    }

    public void serve() {
        for(Map.Entry<Integer, KarakTea> entry: orders.entrySet()) {
            System.out.println("Serving tea to table# " + entry.getKey());
        }
    }
}
