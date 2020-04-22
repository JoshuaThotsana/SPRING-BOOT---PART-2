package com.joshua.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApplication {

    public static void main(String[] args) {

        // Without using spring framework
        FakeRepo fakeRepo = new FakeRepo();

        fakeRepo.insertUser(1001,"Joshua1","Mabotsa1");
        fakeRepo.insertUser(1002,"Joshua2","Mabotsa2");
        fakeRepo.insertUser(1003,"Joshua3","Mabotsa3");
        fakeRepo.insertUser(1004,"Joshua4","Mabotsa4");
        System.out.println();
        System.out.println("Array size is:  " + fakeRepo.userArrayList.size());
        System.out.println();
        System.out.println(fakeRepo.findUserById(1003));
        System.out.println();
        fakeRepo.deleteUser(1001);
        System.out.println();
        System.out.println("Array size is:  " + fakeRepo.userArrayList.size());

        // Using spring annotations
        ApplicationContext context = new AnnotationConfigApplicationContext(UserServiceImpl.class);
        UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);
        service.addUser("Joshua","Mabotsa");
        service.getUser(1001);
        service.removeUser(1001);


    }

}
