package com.example.filestask.controllers;

import com.example.filestask.models.Car;
import com.example.filestask.models.Product;
import com.example.filestask.models.User;
import com.example.filestask.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/save")
    public void save() {
        User user = new User("oleg");
        userService.save(user);
    }

    @PostMapping("/saveWithProducts")
    public void saveWithProducts() {
        User user = new User("dima");
        List<Product> products = new ArrayList<>();
        products.add(new Product("milk"));
        products.add(new Product("kokos"));
        user.setProducts(products);
        userService.save(user);
    }

    @PostMapping("/saveWithCars")
    public void saveWithCars() {
        User user = new User("max");
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("subaru"));
        user.setCars(cars);
        userService.save(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/saveWithImg")
    public void saveWithImg(@RequestParam String name, @RequestParam MultipartFile image) {

        String pathToImgFolder = System.getProperty("user.home") + File.separator + "pictures1" + File.separator + image.getOriginalFilename();
        try {
            image.transferTo(new File(pathToImgFolder));
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setName(name);

        String filename = image.getOriginalFilename();
        user.setImg(filename);

        userService.save(user);
    }

    @GetMapping("/{id}")
    public User getImgOfUser(@PathVariable int id) {
        return userService.getUserOfImg(id);
    }
}
