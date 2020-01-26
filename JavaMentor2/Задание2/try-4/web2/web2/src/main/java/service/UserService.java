package service;

import model.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    /* хранилище данных */
    //   private Map<Long, User> dataBase = Collections.synchronizedMap(new HashMap<>());
    private Map<Long, User> dataBase = new HashMap<>();
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);
    /* список авторизованных пользователей */
    private Map<Long, User> authMap = Collections.synchronizedMap(new HashMap<>());
    private static volatile UserService userService;

    private UserService() {
    }

    public static UserService getInstance() {
        System.out.println(userService);
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
        return new ArrayList<>(dataBase.values());
    }

    public User getUserById(Long id) {
        User user = dataBase.get(id);
        return user;
    }

    public boolean addUser(User user) {
        if (isExistsThisUser(user)) {
            return false;
        }
        synchronized (this) {
            Long id = maxId.getAndIncrement();
            user.setId(id);
            dataBase.put(id, user);
        }
        return true;
    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    public boolean isExistsThisUser(User user) {
        List<User> users = getAllUsers();
        for (User userInDataBase : users) {
            if (userInDataBase.getEmail().equals(user.getEmail()))
                return true;
        }
        return false;
    }

    public List<User> getAllAuth() {
        return new ArrayList<>(authMap.values());
    }

    public boolean authUser(User user) {
        if (!isExistsThisUser(user)) {
            return false;
        }
        synchronized (this) {
            List<User> users = getAllUsers();
            for (User userInDataBase : users) {
                if (userInDataBase.getEmail().equals(user.getEmail()) && userInDataBase.getPassword().equals(user.getPassword())) {
                    authMap.put(userInDataBase.getId(), userInDataBase);
                    return true;
                }
            }
            return false;
        }
    }

    public void logoutAllUsers() {
        authMap.clear();
    }

    public boolean isUserAuthById(Long id) {
        User user = authMap.get(id);
        return user != null;
    }

}
