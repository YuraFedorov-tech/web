import model.User;
import service.UserService;

import java.util.List;

public class MyMain {
    UserService userService;
    public static void main(String[] args) throws Exception{
        MyMain myMain=new MyMain();
        myMain.initUserService();


    }
//java -jar WebTestMachine.jar
    private  void initUserService() {
        userService=UserService.getInstance();
        userService.addUser(new User("11", "111"));
        userService.addUser(new User("22", "222"));
        userService.addUser(new User("22", "222"));
        userService.addUser(new User("33", "333"));
        userService.authUser(new User("33", "333"));
        List<User> users=userService.getAllUsers();


    }
}
