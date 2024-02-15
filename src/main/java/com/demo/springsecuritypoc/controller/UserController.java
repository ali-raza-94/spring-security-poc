package com.demo.springsecuritypoc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(path = "/")
    public String get() {
        return "Any Body";
    }
    @GetMapping(path = "/user")
    public String getUser() {
        return "Ali Raza";
    }
    @GetMapping(path = "/admin")
    public String getAdmin() {
        return "Ali Raza Admin";
    }
}
