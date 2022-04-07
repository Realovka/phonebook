package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.controller.UserController;
import by.company.phonebook.controller.impl.UserControllerImpl;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.exception.StopApplicationException;
import by.company.phonebook.util.Input;

import static by.company.phonebook.action.message.ApplicationMessage.ENTER_USER_ID;
import static by.company.phonebook.action.message.ApplicationMessage.FIND_BY_ID;

public class FindUserActionImpl implements Action {

    private UserController userController = UserControllerImpl.getInstance();

    @Override
    public String getName() {
        return FIND_BY_ID;
    }

    @Override
    public void getAction() throws StopApplicationException {
        int id = Input.getInt(ENTER_USER_ID);
        UserDto userDto = userController.findById(id);
        if (userDto != null) {
            System.out.println(userDto);
        }
    }
}
