package christmas.domain.meal;

import java.util.HashMap;
import java.util.Map;

public class Appetizer extends Meal {
    Map<String, Integer> appetizers;
    public Appetizer() {
        appetizers = new HashMap<>();
        appetizers.put("양송이수프", 6000);
        appetizers.put("타파스", 5500);
        appetizers.put("시저샐러드", 8000);
    }

    @Override
    public String getName() {
        return "appetizer";
    }

    @Override
    public Map<String, Integer> getMenu() {
        return appetizers;
    }

}
