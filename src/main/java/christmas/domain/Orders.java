package christmas.domain;

import christmas.domain.meal.*;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Meal> menus = new ArrayList<>();
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        menus.add(new Appetizer());
        menus.add(new Main());
        menus.add(new Dessert());
        menus.add(new Beverage());
        this.orders = orders;
    }

    public int countDessertMenus() {
        int count = 0;
        Meal dessert = null;
        for (Meal meal : menus) {
            if (meal.getName().equals("dessert")) {
                dessert = meal;
            }
        }
        if (dessert == null) {
            return -1;
        }
        for (Order order : orders) {
            if (dessert.getMenu().containsKey(order.getName())) {
                count += order.getQuantity();
            }
        }
        return count;
    }

    public int countMainMenus() {
        int count = 0;
        Meal main = null;
        for (Meal meal : menus) {
            if (meal.getName().equals("main")) {
                main = meal;
            }
        }
        if (main == null) {
            return -1;
        }
        for (Order order : orders) {
            if (main.getMenu().containsKey(order.getName())) {
                count += order.getQuantity();
            }
        }
        return count;
    }

    public int getPrice(String name) {
        for (Meal meal : menus) {
            if (meal.getMenu().containsKey(name)) {
                return meal.getMenu().get(name);
            }
        }
        return -1;
    }

    public int getTotalCost() {
        int total = 0;
        for (Order order : orders) {
            total += getPrice(order.getName()) * order.getQuantity();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Order order : orders) {
            builder.append(order);
            builder.append("\n");
        }
        return builder.toString();
    }
}



