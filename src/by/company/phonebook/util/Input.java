package by.company.phonebook.util;

import java.util.Scanner;

import static by.company.phonebook.action.message.ApplicationMessage.THIS_IS_NOT_INTEGER;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        }
        System.out.println(scanner.nextLine() + THIS_IS_NOT_INTEGER);
        return getInt();
    }

    public static int getInt(String message) {
        System.out.println(message);
        return getInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static String getString(String message) {
        System.out.println(message);
        return getString();
    }
}
