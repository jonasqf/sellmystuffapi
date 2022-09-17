package com.jonasqf.sellmystuff;

import com.jonasqf.sellmystuff.domain.Role;
import com.jonasqf.sellmystuff.domain.User;
import com.jonasqf.sellmystuff.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SellmystuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellmystuffApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_USER"));

			userService.saveUser(new User(null, "admin", "admin@admin.com", "adminpass", new ArrayList<>()));
			userService.saveUser(new User(null, "user", "user@user.com", "userpass", new ArrayList<>()));

			userService.addRoleToUser("admin@admin.com", "ROLE_ADMIN");
			userService.addRoleToUser("admin@admin.com", "ROLE_USER");
			userService.addRoleToUser("user@user.com", "ROLE_USER");

		};
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
