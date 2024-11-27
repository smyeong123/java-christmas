package christmas.controller;

import christmas.service.handler.DateHandler;
import christmas.view.InputView;

public class DateController {
    private int date;

    public DateController() {

    }

    public void run() {
        boolean isValid = false;
        while (!isValid) {
            try {
                String userResponse = InputView.readExpectedDate();
                date = DateHandler.handle(userResponse);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getDate() {
        return date;
    }
}
