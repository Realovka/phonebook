package by.company.phonebook.application;

import java.util.HashMap;
import java.util.Map;

import static by.company.phonebook.action.message.ApplicationMessage.EMAIL;
import static by.company.phonebook.action.message.ApplicationMessage.FIRST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.LAST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.ROLE;
import static by.company.phonebook.action.message.ApplicationMessage.TELEPHONE;

public class FieldMenu {

    public static Map<Integer, String> fields = new HashMap<>();

    static {
        fields.put(1, FIRST_NAME);
        fields.put(2, LAST_NAME);
        fields.put(3, EMAIL);
        fields.put(4, ROLE);
        fields.put(5, TELEPHONE);
    }
}
