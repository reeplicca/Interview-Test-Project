package kz.BekAidar.Library.controllers;

import kz.BekAidar.Library.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kz.BekAidar.Library.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private  final AmqpTemplate template;

    @Autowired
    public UserController(AmqpTemplate template) {
        this.template = template;
    }

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<String> addUser(@RequestBody User user) {
        logger.info("Emit to myQueue");
        template.convertAndSend("myQueueUser",user);
        return ResponseEntity.ok("Success emit to queue");
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
