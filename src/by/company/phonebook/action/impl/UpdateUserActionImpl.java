package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.action.menu.UserMenu;
import by.company.phonebook.controller.UserController;
import by.company.phonebook.controller.impl.UserControllerImpl;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.exception.StopApplicationException;
import by.company.phonebook.util.Input;

import java.util.Map;
import java.util.Set;

import static by.company.phonebook.action.message.ApplicationMessage.ENTER_FIRST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_LAST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_TELEPHONE;
import static by.company.phonebook.action.message.ApplicationMessage.ENTER_USER_ID;
import static by.company.phonebook.action.message.ApplicationMessage.NO_SUCH_ID;
import static by.company.phonebook.action.message.ApplicationMessage.UPDATE_USER;
import static by.company.phonebook.action.message.ApplicationMessage.USER_HAD_THEE_TELEPHONES;

public class UpdateUserActionImpl implements Action {

    private UserController userController = UserControllerImpl.getInstance();

    @Override
    public String getName() {
        return UPDATE_USER;
    }

    @Override
    public void getAction() throws StopApplicationException {
        UserMenu.showFieldMenu();
        int fieldNumber = Input.getInt();
        if(fieldNumber == 0) {
            return;
        }
        int id = Input.getInt(ENTER_USER_ID);
        while (!userController.isUserExist(id)) {
            System.out.println(NO_SUCH_ID);
            id = Input.getInt(ENTER_USER_ID);
        }
        UserDto userDto = null;
        String fieldValue;
        switch (fieldNumber) {
            case 1:
                fieldValue = UserMenu.enterName(ENTER_FIRST_NAME);
                userDto = userController.updateStringField(id, fieldNumber, fieldValue);
                break;
            case 2:
                fieldValue = UserMenu.enterName(ENTER_LAST_NAME);
                userDto = userController.updateStringField(id, fieldNumber, fieldValue);
                break;
            case 3:
                fieldValue = UserMenu.enterEmail();
                userDto = userController.updateStringField(id, fieldNumber, fieldValue);
                break;
            case 4:
                Set<Role> roles = UserMenu.enterRole();
                userDto = userController.updateRole(id, roles);
                break;
            case 5:
                UserMenu.showTelephoneMenu();
                int action = Input.getInt();
                userDto = updateTelephones(action, id);

        }
        UserMenu.printUserDto(userDto);
    }

    private UserDto updateTelephones(int action, int id) {
        Map<Integer, String> telephones = userController.findTelephones(id);
        UserDto userDto = null;
        switch (action) {
            case 1:
                userDto = addTelephone(telephones, id);
                break;
            case 2:
                UserMenu.showTelephones(telephones);
                UserMenu.updateTelephone(telephones);
                userDto = userController.updateTelephones(id, telephones);
                break;
            case 3:
                UserMenu.showTelephones(telephones);
                UserMenu.deleteTelephone(telephones);
                userDto = userController.updateTelephones(id, telephones);
                break;
        }
        return userDto;
    }

    private UserDto addTelephone(Map<Integer, String> telephones, long id) {
        UserDto userDto = null;
        if (telephones.size() == 3) {
            System.out.println(USER_HAD_THEE_TELEPHONES);
        } else {
            String newTelephone = Input.getString(ENTER_TELEPHONE);
            UserMenu.addTelephone(telephones, newTelephone);
            userDto = userController.updateTelephones(id, telephones);
        }
        return userDto;
    }
}
