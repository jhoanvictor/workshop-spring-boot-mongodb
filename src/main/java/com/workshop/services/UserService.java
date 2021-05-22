package com.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshop.domain.User;
import com.workshop.dto.UserDTO;
import com.workshop.repository.UserRepository;
import com.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return repo.insert(user);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User update(User user) {
		User persistUser = findById(user.getId());
		updateData(persistUser, user);
		return repo.save(persistUser);
	}

	private void updateData(User persistUser, User user) {
		persistUser.setName(user.getName());
		persistUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}

}
