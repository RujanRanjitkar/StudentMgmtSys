package com.example.studentmgmtsys.controller;

import com.example.studentmgmtsys.pojo.User.UserDetailRequestPojo;
import com.example.studentmgmtsys.service.User.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String saveUserDetail(@ModelAttribute UserDetailRequestPojo userDetailRequestPojo, HttpSession session) {
        boolean f=userService.checkEmail(userDetailRequestPojo.getEmail());
        if(f){
            session.setAttribute("msg", "Email already exists");
        }
        else {
            userService.saveUserDetail(userDetailRequestPojo);
            if (userDetailRequestPojo != null) {
                session.setAttribute("msg", "Register Successfully");
            } else {
                session.setAttribute("msg", "Something wrong on server");
            }
        }
        return "redirect:/register";
    }
}
