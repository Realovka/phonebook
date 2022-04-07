package by.company.phonebook.dao.impl;

import by.company.phonebook.dao.UserDao;
import by.company.phonebook.entity.User;
import by.company.phonebook.exception.DaoException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String PATH_TO_FILE = "file.txt";

    private UserDaoImpl() {
    }

    private static UserDaoImpl instance = new UserDaoImpl();

    public static UserDaoImpl getInstance() {
        return instance;
    }

    public List<User> findAll() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PATH_TO_FILE))) {
            return (List<User>) objectInputStream.readObject();
        } catch (IOException  | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public void save(List<User> users) throws DaoException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH_TO_FILE))) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
           throw new DaoException(e);
        }
    }
}
