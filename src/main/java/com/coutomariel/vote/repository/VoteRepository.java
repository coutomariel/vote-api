package com.coutomariel.vote.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coutomariel.vote.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	@Query("select v from Vote v where v.created = :date")
	Optional<Vote> findByDate(LocalDate date);
}
