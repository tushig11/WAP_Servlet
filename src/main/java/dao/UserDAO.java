package dao;

import model.User;
import java.util.HashMap;

public class UserDAO {

    HashMap<String, User> userDB = new HashMap<>();
    {
        userDB.put("admin", new User(1, "admin", "123"));
        userDB.put("tushig", new User(2, "tushig", "123"));
    }

    public void addUser(User user){
        userDB.put(user.getUsername(), user);
    }

    public HashMap<String, User> getAllUsers(){
        return this.userDB;
    }

    public int generateId() {
        return userDB.size()+1;
    }

}