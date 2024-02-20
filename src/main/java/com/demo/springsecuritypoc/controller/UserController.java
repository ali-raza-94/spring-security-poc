package com.demo.springsecuritypoc.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
public class UserController {
    @GetMapping(path = "/read")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getUser() {
        return "every user should have read access";
    }
    @GetMapping(path = "/write")
    @PreAuthorize("hasRole('ROLE_STAFF')")
    public String getStaff() {
        return "staff and admin both should have write access";
    }
    @GetMapping(path = "/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAdmin() {
        return "Admin should only have delete access";
    }
    @GetMapping(path = "/")
    @PreAuthorize("hasRole('ROLE_SPECIAL_USER')")
    public String getSpecialUser() {
        return "special user should only have / access";
    }
}
