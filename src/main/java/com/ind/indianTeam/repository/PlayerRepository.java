package com.ind.indianTeam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.indianTeam.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	public Player findByFirstName(String firstName);
	
	public Player findByJersyNo(Integer jersyNo);
}
