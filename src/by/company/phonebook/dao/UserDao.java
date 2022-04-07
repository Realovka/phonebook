package by.company.phonebook.dao;

import by.company.phonebook.entity.User;
import by.company.phonebook.exception.DaoException;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    void save(List<User> users) throws DaoException;

}
