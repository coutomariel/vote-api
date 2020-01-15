package com.coutomariel.vote.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Vote implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private LocalDate created;
	
	@NotNull
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	@NotNull
	@JoinColumn(name = "restaurantId", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Restaurant restaurant;

}
