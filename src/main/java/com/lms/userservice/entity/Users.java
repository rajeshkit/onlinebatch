package com.lms.userservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Schema(description = "id should be number", defaultValue = "0-9")
    @Id
    private Long id;
    @Schema(description = "username is in string", defaultValue = "a-zA-Z0-9")
    private String username;
    private String password;
    @Schema(description = "email shoule be in proper format", defaultValue = "zyx@gmail.com")
    private String email;
}
