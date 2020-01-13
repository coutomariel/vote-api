package com.coutomariel.vote.entity.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RestaurantImputDto {
	
	private Long id;
	@NotNull
	private String name;

}
