package com.coutomariel.vote.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coutomariel.vote.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

	@Query(value = "select top 1 restaurant_id " + "from vote where created = today() "
			+ "group by restaurant_id order by count(*) desc;", nativeQuery = true)
	public Long findWinnerRestaurant();

	@Query(value = 
			"select restaurant_id from (\n" + 
			" SELECT created,restaurant_id, max(VOTES) from\n" + 
			"	( select created, restaurant_id, count(*) as \"VOTES\" \n" + 
			"		from vote \n" + 
			"			group by created, restaurant_id\n" + 
			"	) as consolid\n" + 
			" GROUP BY created ) as tb_winners\n" + 
			"where created between today()-7 and today()", nativeQuery = true)
	public List<Long> findWinnersLastWeek();

}
