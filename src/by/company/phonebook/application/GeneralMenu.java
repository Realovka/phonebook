package by.company.phonebook.application;

import by.company.phonebook.action.Action;
import by.company.phonebook.action.impl.CreateUserActionImpl;
import by.company.phonebook.action.impl.DeleteUserActionImpl;
import by.company.phonebook.action.impl.FindAllUsersActionImpl;
import by.company.phonebook.action.impl.FindUserActionImpl;
import by.company.phonebook.action.impl.StopApplicationActionImpl;
import by.company.phonebook.action.impl.UpdateUserActionImpl;

import java.util.HashMap;
import java.util.Map;

public class GeneralMenu {

    public static Map<Integer, Action> actions = new HashMap<>();

    static {
        actions.put(1, new CreateUserActionImpl());
        actions.put(2, new FindUserActionImpl());
        actions.put(3, new FindAllUsersActionImpl());
        actions.put(4, new UpdateUserActionImpl());
        actions.put(5, new DeleteUserActionImpl());
        actions.put(6, new StopApplicationActionImpl());
    }
}
