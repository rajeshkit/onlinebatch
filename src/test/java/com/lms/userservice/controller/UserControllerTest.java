package com.lms.userservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.userservice.entity.Users;
import com.lms.userservice.service.UserService;
@WebMvcTest(controllers = UserController.class )
@ExtendWith(MockitoExtension.class)
class UserControllerTest {
	//mock the tomcat from test class and the testing method 
	// we can call to controller method and test it
	//controller method internally calling an service method
	//assume that there is no service layer
	//mock the service layer service class return response
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	static List<Users> list1=null;
	static Users user1=null;
	static Users user2=null;
	static Users user3=null;
	
	@BeforeAll
	public static void setUp() {
		user1 = new Users(1L, "abc", "abc@123", "abc@gmail.com");
		user2 = new Users(2L, "bcd", "bcd@123", "bcd@gmail.com");
		user3 = new Users(3L, "def", "def@123", "def@gmail.com");
		list1 = new ArrayList<>();
		list1.add(user1);
		list1.add(user3);
		list1.add(user2);
	}
	
	@Test
	void testGetAllUsers() throws Exception {
		Mockito.when(userService.getAllUsers()).thenReturn(list1);
		//assert(expected,actuals)
		// here need to call controller method mapping endpoint
		// mapping end points
		mockMvc.perform(get("/api/users")).andExpect(status().isOk())
		.andDo(print())
		.andExpect(jsonPath("$[0].id").value(1))
		.andExpect(jsonPath("$[1].id").value(3))
		.andExpect(jsonPath("$[2].id").value(2));
	}

	@Test
	void testGetUserById() throws Exception {
		Mockito.when(userService.getUserById(1)).thenReturn(Optional.of(user1));
		mockMvc.perform(get("/api/users/1")).andExpect(status().is2xxSuccessful())
		.andDo(print())
		.andExpect(jsonPath("$.username").value("abc"))
		.andExpect(jsonPath("$.password").value("abc@123"))
		.andExpect(jsonPath("$.id").value(1));
	
	}
//
//	@Test
//	void testGetMethodName() {
//		fail("Not yet implemented");
//	}
//
	@Test
	void testCreateUser() throws Exception {
		Mockito.when(userService.createUser(user3)).thenReturn(user3);
		mockMvc.perform(post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(user3)))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.id").value(3))
				.andExpect(jsonPath("$.username").value("def"))
				.andExpect(jsonPath("$.password").value("def@123"));
	}
//
//	@Test
//	void testDeleteUser() {
//		fail("Not yet implemented");
//	}

}
