package com.sxli.druiddemo.controller;

import com.sxli.druiddemo.domain.User;
import com.sxli.druiddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean result = userService.register(user);
        if (result) {
            return "注册成功";
        } else {
            return "注册失败";
        }
    }

    @GetMapping("/get")
    public User getById(@RequestParam Long id){
        return userService.getData(id);
    }
}
