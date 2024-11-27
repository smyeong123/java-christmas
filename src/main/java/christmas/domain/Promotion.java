package christmas.domain;

import christmas.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class Promotion {
    private final int date;
    private final Orders orders;

    private boolean redeemedChampagne = false;
    private boolean isPromotionDate = false;
    private boolean isWeekend = false;
    private boolean isStarredDate = false;

    public Promotion(int date, Orders orders) {
        this.date = date;
        this.orders = orders;
        if (date < 26) {
            isPromotionDate = true;
        }
        List<Integer> weekendDateDetails = Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30);
        if (weekendDateDetails.contains(date)) {
            isWeekend = true;
        }

        List<Integer> starredDateDetails = Arrays.asList(3, 10, 17, 24, 25, 31);
        if (starredDateDetails.contains(date)) {
            isStarredDate = true;
        }
        if (orders.getTotalCost() >= 120_000) {
            redeemedChampagne = true;
            OutputView.printRedeemedChampagne();
        }
    }

    public int getChristmasDiscount() {
        return 1000 + 100 * (date - 1);
    }

    public int getWeekdayDiscount() {
        return 2023 * orders.countDessertMenus();
    }

    public int getWeekendDiscount() {
        return 2023 * orders.countMainMenus();
    }

    public boolean isRedeemedChampagne() {
        return redeemedChampagne;
    }

    public boolean isPromotionDate() {
        return isPromotionDate;
    }

    public boolean isStarredDate() {
        return isStarredDate;
    }

    public Orders getOrders() {
        return orders;
    }
    public int getTotalDiscount() {
        int totalDiscount = 0;
        if (isPromotionDate) {
            totalDiscount += getChristmasDiscount();
        }
        if (isWeekend) {
            totalDiscount += getWeekendDiscount();
        }
        if (!isWeekend) {
            totalDiscount += getWeekdayDiscount();
        }
        if (isStarredDate) {
            totalDiscount += 1000;
        }
        if (redeemedChampagne) {
            totalDiscount += 25000;
        }
        return totalDiscount;
    }
}
