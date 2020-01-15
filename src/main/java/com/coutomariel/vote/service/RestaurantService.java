package com.coutomariel.vote.service;

import java.util.List;
import java.util.Optional;

import com.coutomariel.vote.entity.Restaurant;

public interface RestaurantService {
	
	Restaurant save(Restaurant restaurant);
	
	Optional<Restaurant> findById(Long id);
	
	Optional<Restaurant> findWinnerRestaurant();

	List<Restaurant> findAllRestaurants();
	
}
