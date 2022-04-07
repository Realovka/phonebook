package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.action.menu.UserMenu;
import by.company.phonebook.controller.UserController;
import by.company.phonebook.controller.impl.UserControllerImpl;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.exception.StopApplicationException;

import java.util.Set;

import static by.company.phonebook.action.message.ApplicationMessage.CREATE_NEW_USER;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_FIRST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_LAST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.USER_WITH_ID;
import static by.company.phonebook.action.message.ApplicationMessage.WAS_CREATED;

public class CreateUserActionImpl implements Action {

    private UserController userController = UserControllerImpl.getInstance();

    @Override
    public String getName() {
        return CREATE_NEW_USER;
    }

    @Override
    public void getAction() throws StopApplicationException {
        String firstName = UserMenu.enterName(ENTER_FIRST_NAME);
        String lastName = UserMenu.enterName(ENTER_LAST_NAME);
        String email = UserMenu.enterEmail();
        Set<Role> roles = UserMenu.enterRole();
        Set<String> telephones = UserMenu.enterTelephone();

        UserDto userDto = new UserDto.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setRoles(roles)
                .setTelephones(telephones)
                .build();
        long id = userController.create(userDto);
        System.out.println(USER_WITH_ID + id + WAS_CREATED);
    }
}
