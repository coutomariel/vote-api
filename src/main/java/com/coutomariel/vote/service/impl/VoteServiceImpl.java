package com.coutomariel.vote.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.vote.entity.Vote;
import com.coutomariel.vote.repository.VoteRepository;
import com.coutomariel.vote.service.VoteService;
import com.coutomariel.vote.service.exception.InvalidVoteException;

@Service
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteRepository repository;
	
	@Override
	public Vote save(Vote vote) {
		if(isValidVote(vote.getUser().getId())) {
			throw new InvalidVoteException("Cada usuário pode votar apenas uma única vez ao dia!"); 
		}
		vote.setCreated(LocalDate.now());
		return repository.save(vote);
	}
	
	private boolean isValidVote(Long userId) {
		return repository.findByCreatedAndUserId(LocalDate.now(), userId).size()>0;
	}

	
}
