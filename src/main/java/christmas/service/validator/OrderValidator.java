package christmas.service.validator;

import christmas.domain.meal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OrderValidator {
    private static final Pattern ORDER_FORMAT_PATTERN = Pattern.compile("(.*?)-(\\d+)");

    public static void validateFormat(String token) {
        if (!ORDER_FORMAT_PATTERN.matcher(token).matches()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void productExists(String name) {
        List<Meal> meals = setUp();
        for (Meal meal : meals) {
            for (String productName : meal.getMenu().keySet()) {
                if (productName.equals(name)) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private static List<Meal> setUp() {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Appetizer());
        meals.add(new Main());
        meals.add(new Dessert());
        meals.add(new Beverage());
        return meals;
    }
}
