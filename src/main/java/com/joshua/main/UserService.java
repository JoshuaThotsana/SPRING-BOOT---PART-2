package com.joshua.main;

public interface UserService {

    void addUser(String name, String surname);
    void removeUser(long id);
    void getUser(long id);

}
