package com.mServiceOne.userservice.controller;

import com.mServiceOne.userservice.VO.ResponseTemplateVo;
import com.mServiceOne.userservice.entity.User;
import com.mServiceOne.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser from User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment from User Controller");
        return userService.getUserWithDepartment(userId);
    }
}
