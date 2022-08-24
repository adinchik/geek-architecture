package flyweight;

import java.util.HashMap;

public class TeaMaker {
    private HashMap<String, KarakTea> availableTea;

    public TeaMaker() {
        availableTea = new HashMap<>();
    }

    public KarakTea make(String preference) {
        if (!availableTea.containsKey(preference)) {
            availableTea.put(preference, new KarakTea());
        }
        return availableTea.get(preference);
    }
}
