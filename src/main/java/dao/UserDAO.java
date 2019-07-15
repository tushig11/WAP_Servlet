package dao;

import model.User;
import java.util.HashMap;

public abstract class UserDAO {

    static HashMap<String, User> userDB = new HashMap<>();

    public static void DefaultUsers(){
        userDB.put("admin", new User(1, "admin", "123"));
        userDB.put("tushig", new User(2, "tushig", "123"));
    }


    public static void addUser(User user){
        userDB.put(user.getUsername(), user);
    }

    public static HashMap<String, User> getAllUsers(){
        return userDB;
    }

    public int generateId() {
        return userDB.size()+1;
    }

}