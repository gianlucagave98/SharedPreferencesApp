package com.ggave.sharedpreferencesapp.repository;

import com.ggave.sharedpreferencesapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(100, "GGave","1234", "Gianluca Gave"));
        users.add(new User(200, "DAnchillo","12345", "Diego Anchillo"));
        users.add(new User(300, "MLoarte","123", "Moises Loarte"));
    }

    public static User login(String username, String password){
        for(User user:users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }

        return null;
    }
    public static User findByUsername(String username){
        for (User user : users) {
            if(user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
}
