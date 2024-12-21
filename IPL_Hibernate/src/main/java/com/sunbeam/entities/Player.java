package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true , exclude = "playersTeam")
public class Player extends BaseEntity{
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	private LocalDate dob;
	
	@Column(name = "batting_avg")
	private Double battingAvg;
	
	@Column(name = "wickets_taken")
	private Integer wicketsTaken;
	
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team playersTeam;

	public Player(String firstName, String lastName, LocalDate dob, Double battingAvg, Integer wicketsTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}
	
	
}
