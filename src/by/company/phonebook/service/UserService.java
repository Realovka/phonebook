package by.company.phonebook.service;

import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {

     long create(UserDto userRequestDto) throws ServiceException;

     UserDto findById(long id) throws ServiceException;

     boolean isUserExist(long id);

     List<UserDto> findAll();

     UserDto updateStringField(long id, int fieldNumber, String field) throws ServiceException;

     UserDto updateRole(long id, Set<Role> roles) throws ServiceException;

     Map<Integer, String> findTelephones(long id) throws ServiceException;

     UserDto updateTelephones(long id, Map<Integer, String> telephones) throws ServiceException;

     boolean delete(long id) throws ServiceException;
}