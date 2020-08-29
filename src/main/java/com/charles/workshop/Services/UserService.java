package com.charles.workshop.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charles.workshop.Services.exception.ObjectNotFoundException;
import com.charles.workshop.domain.User;
import com.charles.workshop.dto.UserDTO;
import com.charles.workshop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		User user = userRepository.findById(id);
		if(user == null) {
			throw new ObjectNotFoundException("Object not found!");
		}
		return user;

	}

	public User insert(User obj) {

		return userRepository.save(obj);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(String id, User obj) {

		User newObj = userRepository.findById(id);
		updateData(newObj, obj);
		return userRepository.save(newObj);

	}

	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());

	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
