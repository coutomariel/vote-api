package com.coutomariel.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coutomariel.vote.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	@Query(value="select top 1 restaurant_id "
			+ "from vote where created = today() "
			+ "group by restaurant_id order by count(*) desc;", nativeQuery=true )
	public Long findWinnerRestaurant();

}
