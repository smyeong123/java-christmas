package christmas.domain.meal;

import java.util.List;

public class FullCourseMeals {
    public List<Meal> meals = List.of(new Appetizer(), new Main(), new Dessert(), new Beverage());

    public FullCourseMeals() {

    }

    public Meal getAppetizer() {
        for (Meal meal : meals) {
            if (meal instanceof Appetizer) {
                return (Meal) meal;
            }
        }
        return null;
    }

    public Meal getMain() {
        for (Meal meal : meals) {
            if (meal instanceof Main) {
                return (Meal) meal;
            }
        }
        return null;
    }

    public Meal getDessert() {
        for (Meal meal : meals) {
            if (meal instanceof Dessert) {
                return (Meal) meal;
            }
        }
        return null;
    }

    public Meal getBeverage() {
        for (Meal meal : meals) {
            if (meal instanceof Beverage) {
                return (Meal) meal;
            }
        }
        return null;
    }

    public boolean isProductExist(String name) {
        for (Meal meal : meals) {
            if (meal.getMenu().get(name) != null) {
                return true;
            }
        }
        return false;
    }
}
