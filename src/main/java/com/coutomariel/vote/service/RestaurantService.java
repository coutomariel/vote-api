package com.coutomariel.vote.service;

import java.util.List;

import com.coutomariel.vote.entity.Restaurant;

public interface RestaurantService {
	Restaurant save(Restaurant restaurant);

	List<Restaurant> findAllRestaurants();
}
