package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


import lombok.*;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "players")
public class Team extends BaseEntity {
	@Column(length = 100, unique = true)
	private String name;
	
	@Column(length = 10, unique = true)
	private String abbreviation;
	
	@Column(length = 20, nullable = false)
	private String owner;
	
	@Column(name = "max_player_age")
	private Integer maxPlayerAge;
	
	@Column(name = "batting_avg")
	private Double battingAvg;
	
	@Column(name = "wickets_taken")
	private Integer wicketsTaken;
	
	@OneToMany(mappedBy = "playersTeam", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Player> players = new ArrayList<>();

	public Team(String name, String abbreviation, String owner, Integer maxPlayerAge, Double battingAvg,
			Integer wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public Team(String abbreviation, String owner) {
		this.abbreviation = abbreviation;
		this.owner = owner;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
		player.setPlayersTeam(this);
	}
	
	public void removePlayer(Player player) {
		this.players.remove(player);
		player.setPlayersTeam(null);
	}
	
	
	
	
}
