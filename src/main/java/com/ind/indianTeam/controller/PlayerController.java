package com.ind.indianTeam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ind.indianTeam.entity.Player;
import com.ind.indianTeam.exception.PlayerAlreadyPresentException;
import com.ind.indianTeam.exception.PlayerNotFoundException;
import com.ind.indianTeam.serviceImpl.PlayerServiceImpl;

@RestController
@RequestMapping("/bcci")
public class PlayerController extends BaseController {
	static ResponseEntity<Player> response = null;
	static ResponseEntity<List<Player>> res = null;

	@Autowired
	PlayerServiceImpl playerServiceImpl;

	@PostMapping
	public ResponseEntity<?> addPlayer(@RequestBody Player player) throws PlayerAlreadyPresentException {
		Player player1 = playerServiceImpl.addPlayer(player);
		System.out.println("Inside add plahyer");
		if (player1 != null) {
			response = new ResponseEntity<>(player1, HttpStatus.CREATED);
		} else {
			throw new PlayerAlreadyPresentException("Player already present with name of "+player.getFirstName());
		}
		return response;
	}

	@GetMapping
	public ResponseEntity<?> getAllPlayer() {
		List<Player> players = playerServiceImpl.getAllPlayer();
		if (players != null) {
			res = new ResponseEntity<>(players, HttpStatus.OK);
		} else {
			res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return res;
	}

	@PatchMapping("/player/{id}")
	public ResponseEntity<?> updatePlayer(@PathVariable Integer id, @RequestBody Player player) {
		Player player1 = playerServiceImpl.updatePlayer(id, player);
		if (player1 != null) {
			response = new ResponseEntity<>(player1, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPlayerById(@PathVariable Integer id) {
		Player player1 = playerServiceImpl.getById(id);
		if (player1 != null) {
			response = new ResponseEntity<>(player1, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("/player/{jersyNo}")
	public ResponseEntity<?> getByJersyNo(@PathVariable Integer jersyNo) throws PlayerNotFoundException {
		Player player1 = playerServiceImpl.getByJersyNo(jersyNo);
		if (player1 != null) {
			System.out.println("Inside jersy nomber");
			response = new ResponseEntity<Player>(player1, HttpStatus.OK);
		} else {
			throw new PlayerNotFoundException("Player not found with jersy Number = "+jersyNo);
		}
		return response;
	}

	@GetMapping("/player")
	public ResponseEntity<?> updatePlayer(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String character, @RequestParam Integer jersyNo) {
		List<Player> player1 = playerServiceImpl.getPlayer(firstName, lastName, character, jersyNo);
		if (player1 != null) {
			
			res = new ResponseEntity<>(player1, HttpStatus.OK);
		} else {
			res = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return res;
	}
}
