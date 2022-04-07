package by.company.phonebook.entity;

import java.util.Set;

public enum Role {

    USER, CUSTOMER, ADMIN, PROVIDER, SUPER_ADMIN;

    public static Set<Role> getFirstLevel() {
        return Set.of(USER, CUSTOMER);
    }

    public static Set<Role> getSecondLevel() {
        return Set.of(ADMIN, PROVIDER);
    }
}
