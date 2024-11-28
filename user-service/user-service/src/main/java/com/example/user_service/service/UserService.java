package com.example.user_service.service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or Update a user
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }
    // Get a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
