package com.workshop.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User user = new User(1, "Jhoan", "email@email.com");
		User user2 = new User(1, "Victor", "email@email.com");

		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(user, user2));

		return ResponseEntity.ok().body(list);
	}

}
