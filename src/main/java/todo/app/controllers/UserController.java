package todo.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.app.configs.ValidationException;
import todo.app.dao.Users;
import todo.app.dto.CreateUser;
import todo.app.repository.UsersRepo;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	UsersRepo userRepo;

	public static boolean isEmptyNull(String val) {
		return (null == val || val.trim().length() == 0 || val.trim().equalsIgnoreCase("NULL"));
	}

	@PostMapping("/create")
	public Users getAll(@Valid @RequestBody CreateUser createUser) {
		Users user2 = userRepo.findByUsername(createUser.getUsername());
		if (user2 != null) {
			throw new ValidationException("User already existis", "400");
		}
		Users user = new Users();
		user.setPassword(createUser.getPassword());
		user.setUsername(createUser.getUsername());
		user = userRepo.save(user);
		return user;
	}

}
