package com.coutomariel.vote.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutomariel.vote.entity.User;
import com.coutomariel.vote.entity.dto.UserImputDto;
import com.coutomariel.vote.entity.dto.UserResponseDto;
import com.coutomariel.vote.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<UserResponseDto> save(@Valid @RequestBody UserImputDto userImputDto){
		User response = service.save(toEntity(userImputDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDto(response));
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDto>> findAllUsers(){
		List<User> response = service.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(toCollectionResponseDto(response));
	}
	
	
	
	public UserResponseDto toDto(User user) {
		UserResponseDto dto = new UserResponseDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
	private User toEntity(UserImputDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}
	
	private UserResponseDto toResponseDto(User user) {
		UserResponseDto dto = new UserResponseDto();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		return dto;
	}
	
	private List<UserResponseDto> toCollectionResponseDto(List<User> users){
		return users.stream()
				.map(user -> toResponseDto(user))
				.collect(Collectors.toList());
	}
	
}
