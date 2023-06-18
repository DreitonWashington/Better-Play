package com.coralsoft;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import com.coralsoft.domain.entity.User;
import com.coralsoft.domain.repository.UserRepository;
import com.coralsoft.useCase.UserUseCase;

public class UserTests {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(GenreTests.class);
	UserRepository userRepository = new UserUseCase();

	@Test
	void findAllUsers() throws Exception{
		List<User> users = this.userRepository.findAll();
		Assertions.assertNotNull(users);
		logger.info("Users Email-> {}", users.stream().map(x -> x.getEmail()).collect(Collectors.toList()));
	}

	@Test
	void findByIdUser() {

		User user = new User();
		user.setId(1L);
		user = this.userRepository.findById(user.getId());

		Assertions.assertEquals("test@gmail.com", user.getEmail());
		logger.info("User ID-> {}, Email-> {}", user.getId(), user.getEmail());
	}

	@Test
	void saveAndDeleteUser() {
		User user = new User();
		user.setEmail("tesst@gmail.com");
		user.setPassword("testencode64");

		user = this.userRepository.save(user);
		this.userRepository.delete(user.getId());

		Assertions.assertEquals("tesst@gmail.com", user.getEmail());
		logger.info("Saved and Deleted ID-> {}, E-mail->{}", user.getId(), user.getEmail());
	}

	@Test
	void updateUser() {
		User user = new User();
		user.setId(6L);
		user.setEmail("testUpdate@gmail.com");
		user.setPassword("updatePassword123");

		user = this.userRepository.update(user);

		Assertions.assertEquals("testUpdate@gmail.com", user.getEmail());
		logger.info("Updated ID-> {}, Email-> {}", user.getId(), user.getEmail());

	}
}
