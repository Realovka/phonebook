package by.company.phonebook.application;

import by.company.phonebook.entity.Role;

import java.util.HashMap;
import java.util.Map;

import static by.company.phonebook.action.message.ApplicationMessage.FIVE;
import static by.company.phonebook.action.message.ApplicationMessage.FOUR;
import static by.company.phonebook.action.message.ApplicationMessage.ONE;
import static by.company.phonebook.action.message.ApplicationMessage.THREE;
import static by.company.phonebook.action.message.ApplicationMessage.TWO;

public class RoleMenu {

    public static Map<String, Role> roles = new HashMap<>();

    static {
        roles.put(ONE, Role.USER);
        roles.put(TWO, Role.CUSTOMER);
        roles.put(THREE, Role.ADMIN);
        roles.put(FOUR, Role.PROVIDER);
        roles.put(FIVE, Role.SUPER_ADMIN);
    }
}
