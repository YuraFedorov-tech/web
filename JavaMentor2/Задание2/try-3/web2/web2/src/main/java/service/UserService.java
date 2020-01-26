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
        List<User> list = new ArrayList<>(dataBase.values());
        return list;
    }

    public User getUserById(Long id) {
        User user = this.dataBase.get(id);
        return user;
    }

    public boolean addUser(User user) {
        if (isExistsThisUser(user)) {
            return false;
        }
        Long id = 0L;
        synchronized (this) {
            id = maxId.get();
            this.maxId.getAndAdd(1l);
            dataBase.put(id, user);
            user.setId(id);
        }
        return true;
    }

    public void deleteAllUser() {
        dataBase.clear();
    }

    public boolean isExistsThisUser(User user) {
        if (dataBase.isEmpty()) {
            return false;
        }
        boolean ExistOnlyEmail = isExistOnlyEmail(dataBase, user);

        return ExistOnlyEmail;
    }

    private boolean isExistOnlyEmail(Map<Long, User> dataBase, User user) {
        List<User> users = new ArrayList<>(dataBase.values());
        for (User userInBase : users) {
            if (userInBase.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public List<User> getAllAuth() {
        List<User> list = new ArrayList<>(authMap.values());
        return list;
    }

    public boolean authUser(User user) {
        if (isExistOnlyEmail(authMap, user)) {
            return false;
        }

        synchronized (this) {
            Long id = FindId(user);
            if (id == -1)// passwords not equals
                return false;
            authMap.put(id, user);
            user.setId(id);
        }
        return true;
    }

    private Long FindId(User user) {
        Iterator it = this.dataBase.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            User userInBase = (User) pair.getValue();
            if (userInBase.getEmail().equals(user.getEmail()) && userInBase.getPassword().equals(user.getPassword())) {
                return (Long) pair.getKey();
            }

        }
        return -1l; //  it.remove(); // дабы не было ConcurrentModificationException    return null;
    }




    public void logoutAllUsers() {
        authMap.clear();
    }

    public boolean isUserAuthById(Long id) {
        User user = authMap.get(id);
        return user != null;
    }

}
