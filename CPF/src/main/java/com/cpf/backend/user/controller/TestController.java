package com.cpf.backend.user.controller;

import com.cpf.backend.user.entity.User;
import com.cpf.backend.user.service.imp.UserTestServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private UserTestServiceImp userTestService;
    @RequestMapping(value = "/hello")
    public User hello(){
        log.info("hello world");
        User user =new User();
        user.setAge(1);
        user.setName("hello world");
        return user;
    }
    @RequestMapping(value = "/hello1",method = {RequestMethod.GET,RequestMethod.POST})
    public User hello(@RequestParam(value = "name") String name,@RequestParam(value = "age") int age){
        User user =new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
    @RequestMapping(value ="/hello2")
    public User hello(@RequestParam(value="age") int age){
        User user =new User();
        user.setAge(age);
        userTestService.userTest(user);
        return user;
    }

    @PostMapping(value ="/hello3")
    public User hello(@RequestBody User user){
        userTestService.userTest(user);
        return user;
    }
    @PostMapping(value ="/hello4")
    public void hello1(@RequestBody User user){
        userTestService.userTest(user);
    }
}
