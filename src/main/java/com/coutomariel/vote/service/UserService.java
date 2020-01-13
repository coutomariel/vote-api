package com.coutomariel.vote.service;

import java.util.List;

import com.coutomariel.vote.entity.User;

public interface UserService {
	
	public User save(User user);
	public List<User> findAllUsers();

}
