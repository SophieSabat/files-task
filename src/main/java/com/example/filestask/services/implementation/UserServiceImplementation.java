package com.example.filestask.services.implementation;

import com.example.filestask.dao.UserDAO;
import com.example.filestask.models.User;
import com.example.filestask.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UserService {

    private UserDAO userDAO;

    @Override
    public void save(User user) {
        if (user != null) {
            userDAO.save(user);
        }
    }

    @Override
    public List<User> findAll() {
        return userDAO.findALl();
    }

    @Override
    public User getUserOfImg(int id) {
        return userDAO.findALl().get(id);
    }
}
