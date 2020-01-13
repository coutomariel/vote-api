package com.coutomariel.vote.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coutomariel.vote.entity.Restaurant;
import com.coutomariel.vote.repository.RestaurantRepository;
import com.coutomariel.vote.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository repository;
	
	@Override
	public Restaurant save(Restaurant restaurant) {
		return repository.save(restaurant);
	}

	@Override
	public List<Restaurant> findAllRestaurants() {
		return repository.findAll();
	}

}
