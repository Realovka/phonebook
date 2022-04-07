package by.company.phonebook.controller;

import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserController {

    long create(UserDto userRequestDto);

    UserDto findById(long id);

    boolean isUserExist(long id);

    List<UserDto> findAll();

    UserDto updateStringField(long id, int fieldNumber, String field);

    UserDto updateRole(long id, Set<Role> roles);

    Map<Integer, String> findTelephones(long id);

    UserDto updateTelephones(long id, Map<Integer, String> telephones);

    boolean delete(long id);
}
