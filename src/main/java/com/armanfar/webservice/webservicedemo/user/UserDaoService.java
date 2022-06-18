package com.armanfar.webservice.webservicedemo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(10, "Ramin", new Date()));
        users.add(new User(20, "Roya", new Date()));
        users.add(new User(30, "Laya", new Date()));
        users.add(new User(40, "Amin", new Date()));
        users.add(new User(50, "Armin", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setId(users.size() + 1);
        }
        users.add(user);
        return user;
    }

    public User deleteById(int id) {
        User user = findOne(id);
        users.remove(user);
        return user;
    }
}
