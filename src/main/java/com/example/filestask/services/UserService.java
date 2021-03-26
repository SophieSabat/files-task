package com.example.filestask.services;

import com.example.filestask.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface UserService {

    void save(User user);

    List<User> findAll();

    User getUserOfImg(@PathVariable int id);
}
