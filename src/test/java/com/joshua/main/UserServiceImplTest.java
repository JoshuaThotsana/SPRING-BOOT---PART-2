package com.joshua.main;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceImpl.class);
    UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);

    // Tests whether all methods gets created.

    @Test
    void addUser() {
        service.addUser("name","surname");
    }

    @Test
    void getUser() {
        service.addUser("name","surname"); // Add user before Testing getUser method.
        service.getUser(1001);
    }

    @Test
    void removeUser() {
        service.addUser("name","surname"); // Add user before Testing removeUser method.
        service.removeUser(1001);
    }


}