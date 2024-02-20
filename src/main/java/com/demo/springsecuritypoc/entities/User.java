package com.demo.springsecuritypoc.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "App_User")
@Getter
@Setter
public class User {
    @Id
    private Long id;

    private String username;
    private String password;

    private boolean enabled;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}