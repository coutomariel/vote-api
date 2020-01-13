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

import com.coutomariel.vote.entity.Restaurant;
import com.coutomariel.vote.entity.dto.RestaurantImputDto;
import com.coutomariel.vote.entity.dto.RestaurantResponseDto;
import com.coutomariel.vote.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService service;

	@PostMapping
	public ResponseEntity<RestaurantResponseDto> save(@Valid @RequestBody RestaurantImputDto dto) {
		Restaurant response = service.save(toEntity(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDto(response));
	}
	
	@GetMapping
	public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
		List<Restaurant> response = service.findAllRestaurants();
		return ResponseEntity.status(HttpStatus.OK).body(toCollectionResponseDto(response));
	}
	
	private Restaurant toEntity(RestaurantImputDto dto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setId(dto.getId());
		restaurant.setName(dto.getName());
		return restaurant;
	}
	
	private RestaurantResponseDto toResponseDto(Restaurant restaurant) {
		RestaurantResponseDto dto = new RestaurantResponseDto();
		dto.setId(restaurant.getId());
		dto.setName(restaurant.getName());
		return dto;
	}
	
	private List<RestaurantResponseDto> toCollectionResponseDto(List<Restaurant> restaurants){
		return restaurants.stream()
				.map(restaurant -> toResponseDto(restaurant))
				.collect(Collectors.toList());
	}

}
