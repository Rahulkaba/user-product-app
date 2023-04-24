/**
 * 
 */
package org.jsp.boot.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.boot.Repository.UserRepository;
import org.jsp.boot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Userdao {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findUserById(int id) {
		return  repository.findById(id);
	}
	
	public void deleteUser(User user){
		repository.delete(user);
	}
	
	public List<User> findAllUser(){
		return repository.findAll();
	}

}
