package kz.BekAidar.Library.services;

import kz.BekAidar.Library.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUser(Long id);
    User updateUser(User updUser);
    void deleteUser(Long id);
}
