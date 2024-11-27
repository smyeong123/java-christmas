package christmas.controller;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.service.handler.OrderHandler;
import christmas.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    Orders orders;

    public OrderController() {

    }

    public void run() {
        boolean isValid = false;
        while (!isValid) {
            try {
                String userResponse = InputView.readOrder();

                List<String> splitResponse = splitOrders(userResponse);
                List<Order> recordedOrders = new ArrayList<>();
                for (String token : splitResponse) {
                    Order order = OrderHandler.handle(token);
                    recordedOrders.add(order);
                }
                orders = new Orders(recordedOrders);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public Orders getOrders() {
        return orders;
    }

    private static List<String> splitOrders(String userResponse) {
        return List.of(userResponse.split(","));
    }
}
