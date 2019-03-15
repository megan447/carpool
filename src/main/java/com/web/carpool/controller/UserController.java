package com.web.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.carpool.model.User;
import com.web.carpool.service.UserService;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class UserController {
	@Autowired // This means to get the bean called userRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	@Qualifier("userService")
	private UserService userService;

	@GetMapping(path = "/{id}")
	public @ResponseBody User getUserById(@PathVariable(value = "id") int userId) {
		// This returns a JSON or XML with the users
		return userService.findUserById(userId);
	}
}
