package core.impl;

import core.base.Clinic;
import core.base.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zver on 24.11.2015.
 */
public class ClinicImpl implements Clinic {
    private static volatile ClinicImpl instance;

    private ClinicImpl(){

    }

    public static ClinicImpl getInstance() {
        if (instance == null) {
            synchronized (ClinicImpl.class) {
                if (instance == null) instance = new ClinicImpl();
            }
        }
        return instance;
    }
    
    List<User> users = new ArrayList<User>();

    /**
     * счетчик клиентов для генерации id
     */
    Integer counterUsers = 0;

    /**
     * {@inheritDoc}
     */
    public void addUser(User User) {
        counterUsers++;
        User.setId(counterUsers);
        users.add(User);
    }

    /***
     * {@inheritDoc}
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * {@inheritDoc}
     */
    public void removeUser(Integer id) {
        for (User User : users) {
            if (User.getId().equals(id)) {
                users.remove(User);
                return;
            }
        }
        throw new NullPointerException("Клиента с таким id не существует!");
    }

    /**
     * {@inheritDoc}
     */
    public void showInfo() {
        for (User User : users) {
            User.showInfo();
        }
    }

    /**
     * {@inheritDoc}
     */
    public User findByName(String name) {
        User User = null;
        for (User cl : users) {
            if (cl.getName().equals(name)) User = cl;
        }
        if (User == null) {
            throw new NullPointerException("клиента не существует!");
        }
        return User;
    }

    /**
     * {@inheritDoc}
     */
    public User findByPetName(String name) {
        User User = null;
        for (User cl : users) {
            if (cl.getPet().getName().equals(name)) User = cl;
        }
        if (User == null) {
            throw new NullPointerException("клиента не существует!");
        }
        return User;
    }
}
