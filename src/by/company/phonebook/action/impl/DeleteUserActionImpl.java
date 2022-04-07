package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.controller.UserController;
import by.company.phonebook.controller.impl.UserControllerImpl;
import by.company.phonebook.exception.StopApplicationException;
import by.company.phonebook.util.Input;

import static by.company.phonebook.action.message.ApplicationMessage.DELETE_USER;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_USER_ID;
import static by.company.phonebook.action.message.ApplicationMessage.NO_SUCH_ID;
import static by.company.phonebook.action.message.ApplicationMessage.USER_WAS_DELETED;

public class DeleteUserActionImpl implements Action {

    private UserController userController = UserControllerImpl.getInstance();

    @Override
    public String getName() {
        return DELETE_USER;
    }

    @Override
    public void getAction() throws StopApplicationException {
        int id = Input.getInt(ENTER_USER_ID);
        if (userController.delete(id)) {
            System.out.println(USER_WAS_DELETED);
        } else {
            System.out.println(NO_SUCH_ID);
        }
    }
}
