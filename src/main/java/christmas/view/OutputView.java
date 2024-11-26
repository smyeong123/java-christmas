package christmas.view;

import christmas.domain.Orders;
import christmas.domain.Promotion;

public class OutputView {
    public static void greeting() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printMenu(int date, Orders orders) {
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", date);
        System.out.println("<주문 메뉴>");
        System.out.println(orders);
    }

    public static void printTotalCostBeforePromotion(Orders orders) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d\n\n", orders.getTotalCost());
    }

    public static void printRedeemedChampagne() {
        System.out.println("""
                <증정 메뉴>
                샴페인 1개
                """);
    }

    public static void printDiscounts(Promotion promotion) {
        System.out.println("<혜택 내역>");
        if (promotion.isPromotionDate()) {
            System.out.printf("크리스마스 디데이 할인: -%,d원\n", promotion.getChristmasDiscount());
        }
        if (promotion.getWeekendDiscount() == 0 && promotion.getWeekdayDiscount() == 0) {
            System.out.println("없음");
        }
        if (promotion.getWeekendDiscount() > 0) {
            System.out.printf("주말 할인: -%,d원\n", promotion.getWeekendDiscount());
        }
        if (promotion.getWeekdayDiscount() > 0) {
            System.out.printf("평일 할인: -%,d원\n", promotion.getWeekdayDiscount());
        }
        if (promotion.isStarredDate()) {
            System.out.printf("특별 할인: -%,d원\n", 1000);
        }
        if (promotion.isRedeemedChampagne()) {
            System.out.printf("증정 이벤트: -%,d원\n", 25000);
        }
        System.out.println();
    }

    public static void printTotalDiscount(Promotion promotion) {
        System.out.println("<총혜택 금액>");
        if (promotion.getTotalDiscount() > 0) {
            System.out.printf("-%,d원\n\n", promotion.getTotalDiscount());
        }
        System.out.println("0원\n");
    }

    public static void printAfterDiscount(Promotion promotion) {
        System.out.println("<할인 후 예상 결제 금액>");
        int totalDiscountCost = promotion.getTotalDiscount();
        if (promotion.isPromotionDate()) {
            totalDiscountCost -= 25000;
        }
        System.out.printf("%,d원\n\n", promotion.getOrders().getTotalCost() - totalDiscountCost);
        printBadge(totalDiscountCost);
    }

    public static void printBadge(int totalDiscountCost) {
        System.out.println("<12월 이벤트 배지>");
        // TODO modify the logic
        if (totalDiscountCost >= 20000) {
            System.out.println("산타");
            return;
        }
        if (totalDiscountCost >= 10000) {
            System.out.println("트리");
            return;
        }
        if (totalDiscountCost >= 5000) {
            System.out.println("별");
            return;
        }
        System.out.println("없음");
    }
}