package com.zha.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zha.demo.domain.Login;
import com.zha.demo.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo repo;
    public Login login(String username, String password){
        Login user1 = repo.findByUsernameAndPassword(username, password);
        return user1;
    }
}
