package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>(List.of(
            new User(1L, "User-1", 20),
            new User(2L, "User-1", 30),
            new User(3L, "User-1", 40)
        ));
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    public void createUser(User user) {
        user.setId((long) users.size() + 1);
        users.add(user);
    }

    public void updateUser(User user) {
        Optional<User> existingUser = users.stream()
            .filter(updatedUser -> updatedUser.getId().equals(user.getId()))
            .findFirst();

        if (existingUser.isPresent()) {
            users.remove(existingUser.get());
            users.add(user);
        }

    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
