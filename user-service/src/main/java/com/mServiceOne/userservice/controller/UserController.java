package com.mServiceOne.userservice.controller;

import com.mServiceOne.userservice.VO.ResponseTemplateVo;
import com.mServiceOne.userservice.entity.Users;
import com.mServiceOne.userservice.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UsersService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody Users users){
        log.info("Inside saveUser from User Controller");
        return userService.saveUsers(users);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVo getUsersWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment from User Controller");
        return userService.getUsersWithDepartment(userId);
    }
}
