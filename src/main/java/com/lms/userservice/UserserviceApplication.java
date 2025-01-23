package com.lms.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication	
@OpenAPIDefinition(info =  @Info(summary = "Manages the user details",
	description = "User Rest api create user,delete,update,get user uderdetails",
	license =@License(name = "api liscence") ,
	title = "User API",version = "2.0",termsOfService = "2years",
	contact = @Contact(email = "rajesh.kit@gmail.com",name = "rajesh n", url = "rajesh.kit@gmail.com")))
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
}
