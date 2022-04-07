package by.company.phonebook.application;

import java.util.HashMap;
import java.util.Map;

import static by.company.phonebook.action.message.ApplicationMessage.TO_ADD;
import static by.company.phonebook.action.message.ApplicationMessage.TO_DELETE;
import static by.company.phonebook.action.message.ApplicationMessage.TO_UPDATE;

public class UpdateTelephoneMenu {

    public static Map<Integer, String> telephoneMenu = new HashMap<>();

    static {
        telephoneMenu.put(1, TO_ADD);
        telephoneMenu.put(2, TO_UPDATE);
        telephoneMenu.put(3, TO_DELETE);
    }
}
