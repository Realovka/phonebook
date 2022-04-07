package by.company.phonebook.action;

import by.company.phonebook.exception.StopApplicationException;

public interface Action {

    String getName();

    void getAction() throws StopApplicationException;
}
