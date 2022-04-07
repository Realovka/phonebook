package by.company.phonebook.application;

import by.company.phonebook.action.Action;
import by.company.phonebook.exception.StopApplicationException;
import by.company.phonebook.util.Input;

import java.util.Map;

import static by.company.phonebook.action.message.ApplicationMessage.CHOOSE_AN_ACTION;
import static by.company.phonebook.action.message.ApplicationMessage.DELIMITER;
import static by.company.phonebook.action.message.ApplicationMessage.GOOD_BYE;
import static by.company.phonebook.action.message.ApplicationMessage.HELLO;
import static by.company.phonebook.action.message.ApplicationMessage.NO_SUCH_ACTION;

public class ConsoleApplication {

    public static void start() {
        System.out.println(HELLO);
        run();
        System.out.println(GOOD_BYE);
    }

    public static void showMenu() {
        for (Map.Entry<Integer, Action> action : GeneralMenu.actions.entrySet()) {
            System.out.println(action.getKey() + DELIMITER + action.getValue().getName());
        }
    }

    private static void run() {
        while (true) {
            Action action = getAction();
            try {
                action.getAction();
            } catch (StopApplicationException e) {
                break;
            }
        }
    }

    private static Action getAction() {
        showMenu();
        int number = Input.getInt(CHOOSE_AN_ACTION);
        Action action = GeneralMenu.actions.get(number);
        if (action != null) {
            return action;
        }
        System.out.println(NO_SUCH_ACTION);
        return getAction();
    }
}
