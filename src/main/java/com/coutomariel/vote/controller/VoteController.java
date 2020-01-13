package com.coutomariel.vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coutomariel.vote.entity.Vote;
import com.coutomariel.vote.service.VoteService;

@RestController
@RequestMapping("/vote")
public class VoteController {

	@Autowired
	private VoteService service;
	
	@PostMapping
	public ResponseEntity<Vote> save(@RequestBody Vote vote){
		Vote response = service.save(vote);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
}
