package christmas.domain.meal;


import java.util.HashMap;
import java.util.Map;

public class Main extends Meal {
    private final Map<String, Integer> mainDishes;
    public Main() {
        mainDishes = new HashMap<>();
        mainDishes.put("티본스테이크", 55000);
        mainDishes.put("바비큐립", 54000);
        mainDishes.put("해산물파스타", 35000);
        mainDishes.put("크리스마스파스타", 25000);
    }

    @Override
    public String getName() {
        return "main";
    }

    @Override
    public Map<String, Integer> getMenu() {
        return mainDishes;
    }

}
