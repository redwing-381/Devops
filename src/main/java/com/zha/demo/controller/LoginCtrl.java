package com.zha.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.zha.demo.domain.Login;
import com.zha.demo.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class LoginCtrl {
    @Autowired
    private LoginService service;
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login")
    public String processlogin(@RequestParam String username, @RequestParam String password, Model mod) {
        Login user2 = service.login(username, password); 
        if(user2 != null){
            return "redirect:/welcome";
        }else{
            mod.addAttribute("Error", "invalid Credentials");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
    
    
    
}
