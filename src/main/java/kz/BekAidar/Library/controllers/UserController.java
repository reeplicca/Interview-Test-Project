package kz.BekAidar.Library.controllers;

import kz.BekAidar.Library.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import kz.BekAidar.Library.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @PutMapping()
    public User updateUser(@RequestBody User updUser) {
        return userService.updateUser(updUser);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
