package com.lms.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lms.userservice.entity.Users;
import com.lms.userservice.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<Users> getUserById(int id) {
        return userRepository.findById(id);
    }

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}