package com.coutomariel.vote.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.vote.entity.Vote;
import com.coutomariel.vote.repository.RestaurantRepository;
import com.coutomariel.vote.repository.VoteRepository;
import com.coutomariel.vote.service.VoteService;
import com.coutomariel.vote.service.exception.InvalidVoteException;
import com.coutomariel.vote.service.exception.RestaurantWasWinnerInTheLastWeekException;

@Service
public class VoteServiceImpl implements VoteService{

	@Autowired
	private VoteRepository repository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Vote save(Vote vote) {
		if(isInvalidVote(vote.getUser().getId())) {
			throw new InvalidVoteException("Cada usuário pode votar apenas uma única vez ao dia!"); 
		}
		if(isWinnerReataurantLastWeek(vote.getRestaurant().getId())) {
			throw new RestaurantWasWinnerInTheLastWeekException("Restaurante já foi eleito na última semana!");
		}
		
		vote.setCreated(LocalDate.now());
		return repository.save(vote);
	}
	
	private Boolean isInvalidVote(Long userId) {
		return repository.findByCreatedAndUserId(LocalDate.now(), userId).size()>0;
	}

	private Boolean isWinnerReataurantLastWeek(Long userId) {
		List<Long> winnersInTheLastWeek = restaurantRepository.findWinnersLastWeek();
		for (int i = 0; i < winnersInTheLastWeek.size(); i++) {
			Boolean wasWinner = winnersInTheLastWeek.get(i).equals(userId); 
			if(wasWinner) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
}
