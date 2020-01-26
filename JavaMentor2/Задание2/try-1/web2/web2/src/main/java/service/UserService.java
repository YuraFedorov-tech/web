package service;

import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {
    private static volatile UserService userService;
    /* хранилище данных */
    private Map<Long, User> dataBase = Collections.synchronizedMap(new HashMap<>());
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);
    /* список авторизованных пользователей */
    private Map<Long, User> authMap = Collections.synchronizedMap(new HashMap<>());

    private UserService() {
    }

    public static UserService getInstance() {
        UserService localInstance = userService;
        if (localInstance == null) {
            synchronized (UserService.class) {
                localInstance = userService;
                if (localInstance == null) {
                    userService = localInstance = new UserService();
                }
            }
        }
        return localInstance;
    }


    public List<User> getAllUsers() {
        List<User> users = (List) dataBase.values();
        return users;
    }

    public User getUserById(Long id) {
        User user = dataBase.get(id);
        return user;
    }

    public boolean addUser(User user) {
        Long id = maxId.getAndIncrement();
        User user2 = dataBase.put(id, user);
        return user2 != null;
    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    public boolean isExistsThisUser(User user) {
        boolean q = dataBase.containsValue(user);
        return q;
    }

    public List<User> getAllAuth() {
        List<User> users = (List) authMap.values();
        return users;
    }

    public boolean authUser(User user) {
        boolean q = authMap.containsValue(user);
        return q;
    }

    public void logoutAllUsers() {
        authMap.clear();
    }

    public boolean isUserAuthById(Long id) {
        boolean q = authMap.containsKey(id);
        return q;
    }

    public  Map<Long, User> getDateBase() {
        return dataBase;
    }

    public void displayDataBase() {
        List<User> users=(ArrayList)dataBase.values();
        for(User user:users)
            System.out.print(user.toString());
    }

}
