package by.company.phonebook.action.impl;

import by.company.phonebook.action.Action;
import by.company.phonebook.exception.StopApplicationException;

import static by.company.phonebook.action.message.ApplicationMessage.EXIT;

public class StopApplicationActionImpl implements Action {

    @Override
    public String getName() {
        return EXIT;
    }

    @Override
    public void getAction() throws StopApplicationException {
        throw new StopApplicationException();
    }
}
