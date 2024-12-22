package com.sunbeam.ipl.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
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
}


