package com.ind.indianTeam.service;

import java.util.List;

import com.ind.indianTeam.entity.Player;

public interface PlayerService {

	public Player addPlayer(Player player);

	public List<Player> getAllPlayer();
	
	public Player updatePlayer(Integer id, Player player);

	public Player getById(Integer id);

	public Player getByJersyNo(Integer jersyNo);

	public List<Player> getPlayer(String firstName, String lastName, String character, Integer jersyNo);
	
	
}
