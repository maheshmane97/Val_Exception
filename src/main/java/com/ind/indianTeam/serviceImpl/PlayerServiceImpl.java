package com.ind.indianTeam.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ind.indianTeam.entity.Player;
import com.ind.indianTeam.repository.PlayerRepository;
import com.ind.indianTeam.service.PlayerService;
@Service
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	PlayerRepository playerRepository;

	@Override
	public Player addPlayer(Player player) {
		Player player2=playerRepository.findByFirstName(player.getFirstName());
		Player player1=null;
		if(player2==null) {
			player1=playerRepository.save(player);
		}
		return player1;
	}

	@Override
	public List<Player> getAllPlayer() {
		
		return playerRepository.findAll();
	}

	@Override
	public Player updatePlayer(Integer id, Player player) {
		Player player1=playerRepository.findById(id).get();
		player1.setFirstName(player.getFirstName());
		player1.setLastName(player.getLastName());
		player1.setDob(player.getDob());
		player1.setJersyNo(player.getJersyNo());
		player1=playerRepository.save(player1);
		return player1;
	}

	@Override
	public Player getById(Integer id) {
		// TODO Auto-generated method stub
		return playerRepository.findById(id).get();
	}

	@Override
	public Player getByJersyNo(Integer jersyNo) {
		
		return playerRepository.findByJersyNo(jersyNo);
	}

	@Override
	public List<Player> getPlayer(String firstName, String lastName, String character, Integer jersyNo) {
		List<Player> players=playerRepository.findAll();
		List<Player> player=players.stream().filter(e->
		e.getFirstName().equalsIgnoreCase(firstName) || e.getLastName().equalsIgnoreCase(lastName) ||
		e.getFirstName().startsWith(character) || e.getJersyNo()==jersyNo).collect(Collectors.toList());
		
		return player;
	}

}
