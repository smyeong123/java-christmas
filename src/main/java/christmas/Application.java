package christmas;

import christmas.controller.DateController;
import christmas.controller.OrderController;
import christmas.domain.Promotion;
import christmas.view.OutputView;

public class Application {
    public static DateController runDateController() {
        DateController dateController = new DateController();
        dateController.run();
        return dateController;
    }

    public static OrderController runOrderController() {
        OrderController orderController = new OrderController();
        orderController.run();
        return orderController;
    }

    public static void displayMenu(DateController dateController, OrderController orderController) {
        OutputView.printMenu(dateController.getDate(), orderController.getOrders());
        OutputView.printTotalCostBeforePromotion(orderController.getOrders());
    }

    public static Promotion generatePromotion(DateController dateController, OrderController orderController) {
        return new Promotion(dateController.getDate(), orderController.getOrders());
    }

    public static void displayDiscount(Promotion promotion) {
        OutputView.printDiscounts(promotion);
        OutputView.printTotalDiscount(promotion);
        OutputView.printAfterDiscount(promotion);
    }

    public static void main(String[] args) {
        OutputView.greeting();

        DateController dateController = runDateController();
        OrderController orderController = runOrderController();
        displayMenu(dateController, orderController);

        Promotion promotion = generatePromotion(dateController, orderController);
        displayDiscount(promotion);
    }
}
