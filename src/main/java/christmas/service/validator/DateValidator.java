package christmas.service.validator;

public class DateValidator {
    public static boolean isDigit(String userResponse) {
        try {
            Integer.parseInt(userResponse);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static boolean isValidRange(String userResponse) {
        int parsedInput = Integer.parseInt(userResponse);
        if (parsedInput < 1 || parsedInput > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
        return true;
    }
}
