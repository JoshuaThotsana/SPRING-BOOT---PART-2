package com.joshua.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component // Create a container where you will store all your beans(Objects).
@ComponentScan(basePackages = "com.joshua.main") // Scan the com.joshua.main package and put every bean created inside a container.
public class UserServiceImpl implements UserService {

    private FakeRepo repo;

    @Autowired // Use a setter method to inject FakeRepo dependency.
    public void setRepo(FakeRepo repo) {
        this.repo = repo;
    }

    @Override
    public void addUser(String name, String surname) {
        repo.insertUser(1001,name,surname);
        System.out.println(name + " Entered");
    }

    @Override
    public void removeUser(long id) {
        String name;
        for (User user : repo.userArrayList) {
            if (user.getId() == id) {
                name = user.getName();
                repo.deleteUser(id);
                System.out.println(name + " removed.");
                return;
            }
        }
    }

    @Override
    public void getUser(long id) {
        System.out.println("hello " + repo.findUserById(id).split(" ")[0]);
    }
}
