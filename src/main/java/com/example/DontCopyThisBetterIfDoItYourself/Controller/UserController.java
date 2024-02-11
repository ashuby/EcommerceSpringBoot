package com.example.DontCopyThisBetterIfDoItYourself.Controller;

import com.example.DontCopyThisBetterIfDoItYourself.Model.User;
import com.example.DontCopyThisBetterIfDoItYourself.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.userRegistration(user);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody User user) {
        String userName = user.getUserName();
        String password = user.getUserPassword1();
        return userService.userLogin(userName,password);
    }

    @PostMapping("/findById/{userId}")
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
}
