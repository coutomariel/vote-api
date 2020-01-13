package com.coutomariel.vote.entity.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserImputDto {

	@NotNull
	private String email;
	@NotNull
	private String password;
	
}
