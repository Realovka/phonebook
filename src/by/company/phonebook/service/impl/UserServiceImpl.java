package by.company.phonebook.service.impl;

import by.company.phonebook.application.FieldMenu;
import by.company.phonebook.comparator.UserComparator;
import by.company.phonebook.dao.UserDao;
import by.company.phonebook.dao.impl.UserDaoImpl;
import by.company.phonebook.service.dto.UserDto;
import by.company.phonebook.entity.Role;
import by.company.phonebook.entity.User;
import by.company.phonebook.exception.DaoException;
import by.company.phonebook.exception.ServiceException;
import by.company.phonebook.service.mapper.Mapper;
import by.company.phonebook.service.mapper.impl.UserMapperImpl;
import by.company.phonebook.service.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static by.company.phonebook.action.message.ApplicationMessage.EMAIL;
import static by.company.phonebook.action.message.ApplicationMessage.FIRST_NAME;
import static by.company.phonebook.action.message.ApplicationMessage.LAST_NAME;

public class UserServiceImpl implements UserService {

    private UserServiceImpl() {
    }

    private static UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private Mapper<User, UserDto> userMapper = UserMapperImpl.getInstance();
    private UserDao userDao = UserDaoImpl.getInstance();

    @Override
    public long create(UserDto userDto) throws ServiceException {
        User user = userMapper.mapToEntity(userDto);
        List<User> users = userDao.findAll();
        User userWithMaxId = users.stream().max(new UserComparator()).orElse(new User());
        if (!userWithMaxId.equals(new User())) {
            user.setId(userWithMaxId.getId() + 1);
        } else {
            user.setId(1L);
        }
        boolean result = users
                .stream()
                .anyMatch(userFromFile -> userFromFile.getEmail().equals(user.getEmail()));
        if (result) {
            throw new ServiceException("Such email already exists");
        } else {
            users.add(user);
            try {
                userDao.save(users);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return user.getId();
    }

    @Override
    public UserDto findById(long id) throws ServiceException {
        User user = findUserById(id);
        return userMapper.mapToDto(user);
    }

    @Override
    public boolean isUserExist(long id) {
        List<User> users = userDao.findAll();
        return users
                .stream().anyMatch(userFromCollection -> userFromCollection.getId() == id);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userDao.findAll();
        return users.stream()
                .map(user -> userMapper.mapToDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateStringField(long id, int fieldNumber, String field) throws ServiceException {
        User user = findUserById(id);
        String fieldNumberInMap = FieldMenu.fields.get(fieldNumber);
        switch (fieldNumberInMap) {
            case FIRST_NAME:
                user.setFirstName(field);
                break;
            case LAST_NAME:
                user.setLastName(field);
                break;
            case EMAIL:
                user.setEmail(field);
                break;
        }
        return save(user);
    }

    @Override
    public UserDto updateRole(long id, Set<Role> roles) throws ServiceException {
        User user = findUserById(id);
        user.setRoles(roles);
        return save(user);
    }

    @Override
    public Map<Integer, String> findTelephones(long id) throws ServiceException {
        User user = findUserById(id);
        Set<String> telephonesFromFile = user.getTelephones();
        Map<Integer, String> userTelephones = new HashMap<>();
        AtomicInteger key = new AtomicInteger(0);
        telephonesFromFile.forEach(telephoneFromFile -> {
            int keyMap = key.incrementAndGet();
            userTelephones.put(keyMap, telephoneFromFile);
        });
        return userTelephones;
    }

    @Override
    public UserDto updateTelephones(long id, Map<Integer, String> telephones) throws ServiceException {
        User user = findUserById(id);
        Set<String> phones = new HashSet<>(telephones.values());
        user.setTelephones(phones);
        return save(user);
    }

    @Override
    public boolean delete(long id) throws ServiceException {
        List<User> users = userDao.findAll();
        boolean result = users.removeIf(userFromFile -> userFromFile.getId() == id);
        try {
            userDao.save(users);
        } catch (DaoException e) {
            throw new ServiceException();
        }
        return result;
    }

    private User findUserById(long id) throws ServiceException {
        List<User> users = userDao.findAll();
        return users
                .stream().filter(userFromCollection -> userFromCollection.getId() == id)
                .findFirst().orElseThrow(() -> new ServiceException("No such id"));
    }

    private UserDto save(User user) throws ServiceException {
        List<User> users = userDao.findAll();
        users.removeIf(userFromFile -> userFromFile.getId() == user.getId());
        users.add(user);
        try {
            userDao.save(users);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return findById(user.getId());
    }
}
