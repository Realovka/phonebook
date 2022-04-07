package by.company.phonebook.action.menu;

import by.company.phonebook.entity.Role;
import by.company.phonebook.validator.UserValidator;

import java.util.Set;

import static by.company.phonebook.action.message.ApplicationMessage.INVALID_EMAIL;
import static by.company.phonebook.action.message.ApplicationMessage.INVALID_ROLE;
import static by.company.phonebook.action.message.ApplicationMessage.INVALID_TELEPHONE;
import static by.company.phonebook.action.message.ApplicationMessage.STRING_IS_INVALID;

public class ValidationMessage {

    public static boolean checkName(String name) {
        if (!UserValidator.isNameValid(name)) {
            System.out.println(STRING_IS_INVALID);
            return false;
        }
        return true;
    }

    public static boolean checkEmail(String email) {
        if (!UserValidator.isEmailValid(email)) {
            System.out.println(INVALID_EMAIL);
            return false;
        }
        return true;
    }

    public static boolean checkRole(Set<Role> roles) {
        if (!UserValidator.isRolesSetValid(roles)) {
            roles.clear();
            System.out.println(INVALID_ROLE);
            return false;
        }
        return true;
    }

    public static boolean checkTelephone(String telephone) {
        if (!UserValidator.isTelephoneValid(telephone)) {
            System.out.println(INVALID_TELEPHONE);
            return false;
        }
        return true;
    }
}
