package by.company.phonebook.controller.impl;

import by.company.phonebook.controller.UserController;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.exception.ServiceException;
import by.company.phonebook.service.UserService;
import by.company.phonebook.service.impl.UserServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserControllerImpl implements UserController {

    private UserControllerImpl() {
    }

    private static UserControllerImpl instance = new UserControllerImpl();

    public static UserControllerImpl getInstance() {
        return instance;
    }

    private UserService userService = UserServiceImpl.getInstance();

    @Override
    public long create(UserDto userDto) {
        long id = 0;
        try {
            id = userService.create(userDto);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public UserDto findById(long id) {
        UserDto userDto = null;
        try {
            userDto = userService.findById(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public boolean isUserExist(long id) {
        return userService.isUserExist(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @Override
    public UserDto updateStringField(long id, int fieldNumber, String field) {
        UserDto userDto = null;
        try {
            userDto = userService.updateStringField(id, fieldNumber, field);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public UserDto updateRole(long id, Set<Role> roles) {
        UserDto userDto = null;
        try {
            userDto = userService.updateRole(id, roles);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public Map<Integer, String> findTelephones(long id) {
        Map<Integer, String> telephones = null;
        try {
            telephones = userService.findTelephones(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return telephones;
    }

    @Override
    public UserDto updateTelephones(long id, Map<Integer, String> telephones) {
        UserDto userDto = null;
        try {
            userDto = userService.updateTelephones(id, telephones);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return userDto;
    }

    @Override
    public boolean delete(long id) {
        boolean result = false;
        try {
            result =  userService.delete(id);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return result;
    }
}
