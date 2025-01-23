package com.lms.userservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lms.userservice.entity.Users;
import com.lms.userservice.repository.UsersRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	@Mock
	private UsersRepository usersRepository;

	@InjectMocks
	private UserService userService; // create as a bean

	@Test
	void testGetAllUsers() {
		Users user1 = new Users(1L, "abc", "anc@123", "abc@gmail.com");
		Users user2 = new Users(2L, "bcd", "bcd@123", "bcd@gmail.com");
		Users user3 = new Users(3L, "def", "def@123", "def@gmail.com");
		List<Users> list1 = new ArrayList<>();
		list1.add(user1);
		list1.add(user3);
		list1.add(user2);
		Mockito.when(usersRepository.findAll()).thenReturn(list1);
		List<Users> list = userService.getAllUsers();
		assertEquals(3, list.size());
	}

	@Test
	void testGetUserByEmail() {
		Users user1 = new Users(1L, "abc", "anc@123", "abc@gmail.com");
		Mockito.when(usersRepository.findByEmail("abc@gmail.com")).thenReturn(user1);
		Users users= userService.getUserByEmail("abc@gmail.com");
		assertEquals(1L, users.getId());
		assertEquals("abc", users.getUsername());
		assertEquals("abc@gmail.com", users.getEmail());
		assertEquals(user1, users);
	}

	@Test
	void testGetUserById() {
		Users user1 = new Users(1L, "abc", "anc@123", "abc@gmail.com");
		Mockito.when(usersRepository.findById(1)).thenReturn(Optional.of(user1));
		assertSame(user1, userService.getUserById(1).get());
	}

	@Test
	void testCreateUser() {
		Users user1 = new Users(1L, "abc", "anc@123", "abc@gmail.com");
		Mockito.when(usersRepository.save(user1)).thenReturn(user1);
		assertSame(user1,userService.createUser(user1));
	}

	@Test
	void testDeleteUser() {
		Users user1 = new Users(1L, "abc", "anc@123", "abc@gmail.com");
		Mockito.spy(UsersRepository.class).deleteById(1);
	}

}
