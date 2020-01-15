package com.coutomariel.vote.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coutomariel.vote.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	List<Vote> findByCreatedAndUserId(LocalDate created, Long userId);
	
}
