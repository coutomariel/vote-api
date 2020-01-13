package com.coutomariel.vote.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.vote.entity.Vote;
import com.coutomariel.vote.repository.VoteRepository;
import com.coutomariel.vote.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteRepository repository;
	
	@Override
	public Vote save(Vote vote) {
		vote.setCreated(LocalDate.now());
		return repository.save(vote);
	}

}
