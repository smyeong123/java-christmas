package christmas.service.handler;

import christmas.domain.Order;
import christmas.service.validator.OrderValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderHandler {
    public static Order handle(String token) {
        OrderValidator.validateFormat(token);
        return createOrder(token);
    }

    public static Order parseToken(String token) {
        Pattern pattern = Pattern.compile("(.*?)-(\\d+)");
        Matcher matcher = pattern.matcher(token);

        if (matcher.matches()) {
            String name = matcher.group(1).trim();
            OrderValidator.productExists(name);
            int quantity = Integer.parseInt(matcher.group(2));
            return new Order(name, quantity);
        } else {
            throw new IllegalArgumentException("[ERROR] Failed to parse token: " + token);
        }
    }

    public static Order createOrder(String token) {
        return parseToken(token);
    }
}
