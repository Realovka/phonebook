package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.controller.UserController;
import by.company.phonebook.controller.impl.UserControllerImpl;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.exception.StopApplicationException;

import java.util.List;

import static by.company.phonebook.action.message.ApplicationMessage.FIND_ALL_USERS;

public class FindAllUsersActionImpl implements Action {

    private UserController userController = UserControllerImpl.getInstance();

    @Override
    public String getName() {
        return FIND_ALL_USERS;
    }

    @Override
    public void getAction() throws StopApplicationException {
        List<UserDto> users = userController.findAll();
        users.forEach(System.out::println);
    }
}
