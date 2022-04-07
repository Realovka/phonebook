package by.company.phonebook.validator;

import by.company.phonebook.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class UserValidator {

    private static final String NAME_VALIDATOR = "[A-Za-x -]+$";
    private static final String EMAIL_VALIDATOR = "\\w+@\\w+\\.\\w+";
    private static final String TELEPHONE_VALIDATOR = "(375)([0-9]{9})$";

    public static boolean isNameValid(String name) {
        return !name.isBlank() && name.matches(NAME_VALIDATOR);
    }

    public static boolean isEmailValid(String email) {
        return email.matches(EMAIL_VALIDATOR);
    }

    public static boolean isRolesSetValid(Set<Role> roles) {

        if (!roles.contains(Role.SUPER_ADMIN) && roles.size() > 1) {
            return checkRoleLevel(roles);
        } else {
            return roles.size() == 1;
        }
    }

    public static boolean isTelephoneValid(String telephone) {
        return telephone.matches(TELEPHONE_VALIDATOR);
    }

    private static boolean checkRoleLevel(Set<Role> roles) {
        int size = roles.size();
        Set<Role> firstCopy = new HashSet<>(roles);
        Set<Role> secondCopy = new HashSet<>(roles);
        Set<Role> firstLevel = Role.getFirstLevel();
        Set<Role> secondLevel = Role.getSecondLevel();
        firstCopy.addAll(firstLevel);
        secondCopy.addAll(secondLevel);
        return size + 1 == firstCopy.size() && size + 1 == secondCopy.size();
    }
}