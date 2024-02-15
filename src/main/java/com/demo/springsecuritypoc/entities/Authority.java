package com.demo.springsecuritypoc.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name= "authority")
@Data
public class Authority {
    @Id
    private Long id;
    private String authority;
    @ManyToMany(mappedBy = "userAuthorities")
    private List<User> user;
}
