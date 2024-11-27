package christmas.service.handler;

import christmas.service.validator.DateValidator;

public class DateHandler {
    public static int handle(String userResponse) {
        if (DateValidator.isDigit(userResponse) && DateValidator.isValidRange(userResponse) ) {
            return Integer.parseInt(userResponse);
        }
        throw new IllegalArgumentException("[ERROR]유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
