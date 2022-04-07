package by.company.phonebook.action.menu;

import by.company.phonebook.application.FieldMenu;
import by.company.phonebook.application.RoleMenu;
import by.company.phonebook.application.UpdateTelephoneMenu;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.util.Input;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static by.company.phonebook.action.message.ApplicationMessage.CHOICE_IS_WRONG;
import static by.company.phonebook.action.message.ApplicationMessage.CHOOSE_AN_ACTION;
import static by.company.phonebook.action.message.ApplicationMessage.CHOOSE_ROLE;
import static by.company.phonebook.action.message.ApplicationMessage.DELIMITER;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_A_NEW_NUMBER;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_EMAIL;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_SERIAL_NUMBER_OF_TELEPHONE;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_TELEPHONE;
import static by.company.phonebook.action.message.ApplicationMessage.PRESS_THE_SPACE_BAR;
import static by.company.phonebook.action.message.ApplicationMessage.PUT_ZERO_FOR_EXIT;
import static by.company.phonebook.action.message.ApplicationMessage.USER_IS_AFTER_UPDATE;
import static by.company.phonebook.action.message.ApplicationMessage.WHAT_VALUE_UPDATE;

public class UserMenu {

    public static String enterName(String message) {
        String name = null;
        boolean flag = true;
        while (flag) {
            name = Input.getString(message);
            flag = !ValidationMessage.checkName(name);
        }
        return name;
    }

    public static String enterEmail() {
        String email = null;
        boolean flag = true;
        while (flag) {
            email = Input.getString(ENTER_EMAIL);
            flag = !ValidationMessage.checkEmail(email);
        }
        return email;
    }

    public static Set<Role> enterRole() {
        Set<Role> roles = new HashSet<>();
        while (roles.size() < 2) {
            showRoleMenu();
            String roleNumber = Input.getString();
            if (RoleMenu.roles.containsKey(roleNumber)) {
                Role role = RoleMenu.roles.get(roleNumber);
                roles.add(role);
                ValidationMessage.checkRole(roles);
            } else {
                if (roleNumber.isBlank() && roles.size() > 0) {
                    break;
                } else {
                    System.out.println(CHOICE_IS_WRONG);
                }
            }
        }
        return roles;
    }

    public static Set<String> enterTelephone() {
        Set<String> telephones = new HashSet<>();
        boolean flag = true;
        while (flag && telephones.size() != 3) {
            System.out.println(PRESS_THE_SPACE_BAR);
            String telephone = Input.getString(ENTER_TELEPHONE);
            if (!telephone.isBlank() && ValidationMessage.checkTelephone(telephone)) {
                telephones.add(telephone);
            } else if (telephone.isBlank()) {
                flag = false;
            }
        }
        return telephones;
    }

    public static void addTelephone(Map<Integer, String> telephones, String telephone) {
        if (!telephone.isBlank() && ValidationMessage.checkTelephone(telephone)) {
            Integer maxKey = telephones.keySet()
                    .stream().
                    max(Comparator.comparing(Integer::valueOf))
                    .orElse(1);
            telephones.put(++maxKey, telephone);
        }
    }

    public static void updateTelephone(Map<Integer, String> telephones) {
        int serialNumber;
        do {
            serialNumber = Input.getInt(ENTER_SERIAL_NUMBER_OF_TELEPHONE);
        } while (!telephones.containsKey(serialNumber));
        String telephone = Input.getString(ENTER_A_NEW_NUMBER);
        boolean flag = true;
        while (flag && !telephone.isBlank() && ValidationMessage.checkTelephone(telephone)) {
            telephones.put(serialNumber, telephone);
            flag = false;
        }
    }

    public static void deleteTelephone(Map<Integer, String> telephones) {
        int serialNumber;
        do {
            serialNumber = Input.getInt(ENTER_SERIAL_NUMBER_OF_TELEPHONE);
        } while (!telephones.containsKey(serialNumber));
        telephones.remove(serialNumber);
    }

    public static void showTelephoneMenu() {
        System.out.println(CHOOSE_AN_ACTION);
        UpdateTelephoneMenu.telephoneMenu.forEach((key, value) -> System.out.println(key + DELIMITER + value));
    }

    public static void showFieldMenu() {
        System.out.println(WHAT_VALUE_UPDATE);
        FieldMenu.fields.forEach((key, value) -> System.out.println(key + DELIMITER + value));
        System.out.println(PUT_ZERO_FOR_EXIT);
    }

    public static void showTelephones(Map<Integer, String> phones) {
        phones.forEach((key, value) -> System.out.println(key + DELIMITER + value));
    }

    public static void printUserDto(UserDto userDto) {
        if (userDto != null) {
            System.out.println(USER_IS_AFTER_UPDATE + userDto);
        }
    }

    private static void showRoleMenu() {
        System.out.println(CHOOSE_ROLE);
        for (Map.Entry<String, Role> menuRoles : RoleMenu.roles.entrySet()) {
            System.out.println(menuRoles.getKey() + DELIMITER + menuRoles.getValue());
        }
        System.out.println(PRESS_THE_SPACE_BAR);
    }
}
