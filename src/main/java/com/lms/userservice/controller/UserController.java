package com.lms.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.userservice.entity.Users;
import com.lms.userservice.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Operation(summary = "fetch all users",description = "hit this uri to get all users details")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "All users were fetched"),
    		@ApiResponse(responseCode = "401",description = "Wrong uri")})
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers(); // http response body List<User> - json format
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        Optional<Users> user = userService.getUserById(id);
        return user.get();// http response body User - json format
    }
    @GetMapping("/email/{email}")
    public Users getMethodName(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
