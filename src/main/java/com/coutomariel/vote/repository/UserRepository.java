package com.coutomariel.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coutomariel.vote.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
