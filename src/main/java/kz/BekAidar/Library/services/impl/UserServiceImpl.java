package kz.BekAidar.Library.services.impl;

import kz.BekAidar.Library.entities.User;
import kz.BekAidar.Library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.BekAidar.Library.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findAllById(id);
    }

    @Override
    public User updateUser(User updUser) {
        User user = userRepository.findAllById(updUser.getId());
        user.setName(updUser.getName());
        user.setAge(updUser.getAge());
        user.setLibraries(updUser.getLibraries());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
