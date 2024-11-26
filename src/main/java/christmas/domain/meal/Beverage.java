package christmas.domain.meal;

import java.util.HashMap;
import java.util.Map;

public class Beverage extends Meal {
    Map<String, Integer> beverages;

    public Beverage() {
        beverages = new HashMap<>();
        beverages.put("제로콜라",3000);
        beverages.put("레드와인",60000);
        beverages.put("샴페인",25000);
    }

    @Override
    public String getName() {
        return "beverage";
    }

    @Override
    public Map<String, Integer> getMenu() {
        return beverages;
    }

}
