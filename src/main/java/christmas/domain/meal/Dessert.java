package christmas.domain.meal;

import java.util.HashMap;
import java.util.Map;

public class Dessert extends Meal {
    Map<String, Integer> desserts;
    public Dessert() {
        desserts = new HashMap<>();
        desserts.put("초코케이크", 15000);
        desserts.put("아이스크림", 5000);
    }

    @Override
    public String getName() {
        return "dessert";
    }

    @Override
    public Map<String, Integer> getMenu() {
        return desserts;
    }

}
