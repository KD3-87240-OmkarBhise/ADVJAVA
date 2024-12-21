package com.sunbeam.dao;

import com.sunbeam.entities.Player;

public interface PlayerDao {

	String newPlayer(Long teamId, Player player);

	String deletePlayerFromTeam(Long teamId, Long playerId);
	

}
