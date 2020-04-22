package com.joshua.main;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // This is Persistence layer(Data Access Layer) of application which used to get data from the database.
public class FakeRepo implements FakeRepoInterface {

    ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    public void insertUser(long id, String name, String surname) {
        userArrayList.add(new User(id, name, surname));
        System.out.println("Added user: " + id + " " + name + " " + surname);
    }

    @Override
    public String findUserById(long id) {

        for (User user : userArrayList) {
            if(user.getId() == id)
                return user.getName() + " " + user.getSurname();

        }
        return null;
    }

    @Override
    public void deleteUser(long id) {

        for (int i = 0; i < userArrayList.size(); i++) {
            if(userArrayList.get(i).getId() == id) {
                userArrayList.remove(i);
                System.out.println("Deleted user ID: " +id);
                return;
            }

        }
    }
}
